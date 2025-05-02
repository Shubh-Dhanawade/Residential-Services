package com.example.validatiotrdemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validatiotrdemo.Model.User;
import com.example.validatiotrdemo.Payload.Response.SimpleResponse;
import com.example.validatiotrdemo.Services.UserServices;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/user")
public class RestUserController {

    @Autowired
    UserServices userServices;

    @PostMapping()
    public ResponseEntity<SimpleResponse> userCreateEntity(@Valid @RequestBody User entity) {
        entity = userServices.createUser(entity);
        if (entity == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new SimpleResponse("User not created", HttpStatus.BAD_REQUEST, false));
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SimpleResponse("User created successfully", HttpStatus.CREATED, true));

    }

    @PutMapping()
    public ResponseEntity<SimpleResponse> userUpdateEntity(@Valid @RequestBody User entity) {
        entity = userServices.updateUser(entity);
        if (entity == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new SimpleResponse("User not updated", HttpStatus.BAD_REQUEST, false));
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(new SimpleResponse("User updated successfully", HttpStatus.OK, true));

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> userGetEntity(@PathVariable long id) {

        return ResponseEntity.status(HttpStatus.OK).body(userServices.getUserById(id));

    }

    @GetMapping("/all")
    public ResponseEntity<?> userGetAllEntity() {

        return ResponseEntity.status(HttpStatus.OK).body(userServices.getAllUsers());

    }

}


