package com.example.validatiotrdemo.Controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import com.example.validatiotrdemo.Auth.JwtService;
import com.example.validatiotrdemo.Model.PhotoPost;
import com.example.validatiotrdemo.Model.User;
import com.example.validatiotrdemo.Payload.Response.SimpleResponse;
import com.example.validatiotrdemo.Services.PhotoPostServices;
import com.example.validatiotrdemo.Services.UserServices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/photopost")
public class RestPhotoPostController {

    @Autowired
    PhotoPostServices photoPostServices;

    @Autowired
    UserServices userServices;

    @Autowired
    JwtService jwtService;

    // Upload photo post
    @PostMapping()
    public ResponseEntity<?> postMethodName(@RequestPart MultipartFile file, @RequestPart String caption,
            HttpServletRequest request) {
        // Accessing the token
        String token = request.getHeader("Authorization");
        // System.out.println("-----------------------------Token-----------------------------");
        // System.out.println(token);
        // Removing the Bearer from the token
        token = token.substring(7);

        // Extracting the user from the token
        String email = jwtService.getUsername(token);
        // System.out.println(email);

        // Find user by token
        User user = userServices.getUserByEmail(email);

        PhotoPost photoPost = new PhotoPost();
        photoPost.setCaption(caption);

        // Save image to disk
        String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        String path = new File("src/main/resources/static/images/").getAbsolutePath();

        try {
            file.transferTo(new File(path + "/" + filename));
        } catch (IOException e) {
            e.printStackTrace();
            SimpleResponse response = new SimpleResponse();
            response.setMessage("Failed to save image");
            response.setSuccess(false);
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

        photoPost.setImage(filename);
        photoPost.setUser(user);

        SimpleResponse simpleResponse = new SimpleResponse();
        try {
            photoPost = photoPostServices.createPhotoPost(photoPost);
        } catch (DataIntegrityViolationException e) {
            simpleResponse.setMessage("Duplicate image entry");
            simpleResponse.setSuccess(false);
            simpleResponse.setStatus(HttpStatus.BAD_REQUEST);
            // Delete image from disk
            new File(path + "/" + filename).delete();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(simpleResponse);
        }

        if (photoPost == null) {
            simpleResponse.setMessage("Photo not posted");
            simpleResponse.setSuccess(false);
            simpleResponse.setStatus(HttpStatus.BAD_REQUEST);
            // Delete image from disk
            new File(path + "/" + filename).delete();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(simpleResponse);
        }

        simpleResponse.setMessage("Photo posted successfully");
        simpleResponse.setSuccess(true);
        simpleResponse.setStatus(HttpStatus.OK);

        return ResponseEntity.ok().body(simpleResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPhotoPosts() {
        return ResponseEntity.status(HttpStatus.OK).body(photoPostServices.getAllPhotoPosts());
    }

    @GetMapping("/user")
    public ResponseEntity<?> getAllPhotoPostsByEmail(HttpServletRequest request) {
        // Accessing the token
        String token = request.getHeader("Authorization");
        token = token.substring(7);
        String email = jwtService.getUsername(token);
        System.out.println(email);

        User user = userServices.getUserByEmail(email);

        return ResponseEntity.status(HttpStatus.OK).body(photoPostServices.getPhotoPostsByUser(user));
    }

    // delete photo post
    @DeleteMapping("delete/{postid}")
    public ResponseEntity<?> deletePhotoPost(@PathVariable  ("postid") Long postid) {
        System.out.println(postid);
        SimpleResponse simpleResponse = new SimpleResponse();
        if (photoPostServices.deletePhotoPost(postid)) {
            simpleResponse.setMessage("Photo post deleted successfully");
            simpleResponse.setSuccess(true);
            simpleResponse.setStatus(HttpStatus.OK);
            return ResponseEntity.ok().body(simpleResponse);
        } else {
            simpleResponse.setMessage("Photo post not deleted");
            simpleResponse.setSuccess(false);
            simpleResponse.setStatus(HttpStatus.BAD_REQUEST);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(simpleResponse);
        }
    }

}
