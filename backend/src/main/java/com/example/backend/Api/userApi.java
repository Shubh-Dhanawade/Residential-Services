package com.example.backend.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.Modules.ResponceModel;
import com.example.backend.Modules.User;
import com.example.backend.Service.UserService;

import jakarta.validation.Valid;


@RestController
public class userApi {

    @Autowired
    UserService userService;

    // @PostMapping("/user")
    // public List<User> postMethodName(@Valid @RequestBody User entity) {
        
    //     return userService.addUser(entity);
    // }

    @PostMapping("/login")
    public boolean loginMethodName(@RequestBody User entity) {
       
        
        
        return true;
    }
    @PostMapping("/register")
    public ResponseEntity<?> postMethodName(@Valid @RequestBody User entity) {

        ResponceModel responceModel = new ResponceModel();

        if(userService.addUser(entity)){
            responceModel.setMessage("Register Sussful");
            return ResponseEntity.status(HttpStatus.CREATED).body(responceModel.getMessage());
        }
        else{
           
                responceModel.setMessage("Register Faill");
                return  ResponseEntity.status(HttpStatus.FORBIDDEN).body(responceModel.getMessage());
        }
        
          
        }


    
    @PostMapping("/dashboard")
    public String dashboardMethodName(@RequestBody User entity) {
       
        
        
        return "Hello Dashboard here";
    }

    
    
    

    

    
}
