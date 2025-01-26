package com.example.backend.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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


    @PostMapping("/register")
    public ResponseEntity<?> postMethodName(@Valid @RequestBody User entity) {

        ResponceModel responceModel = new ResponceModel();

        // To response from response model to show result from code like 200, 201 etc
        if(userService.addUser(entity)){
            responceModel.setMessage("Registered Successfully");
            return ResponseEntity.status(HttpStatus.CREATED).body(responceModel.getMessage());
        }
        else{
           
                responceModel.setMessage("Registration Failed");
                return  ResponseEntity.status(HttpStatus.FORBIDDEN).body(responceModel.getMessage());
        }
        
          
        }


    
    @PostMapping("/dashboard")
    public String dashboardMethodName(@RequestBody User entity) {
       
        
        
        return "Hello Dashboard here";
    }

    @GetMapping("/userdata")
    public List<User> getData() {
        return userService.getUser();
    }


    @PostMapping("/login")
    public User loginMethod(@RequestBody User uc) {
        String email = uc.getEmail();
        String password = uc.getPassword();

        System.out.println(email);
        System.out.println(password);

        try{
            return userService.login(email, password);
        }catch(Exception e){
            System.out.println(e);

            return userService.login(email, password);

        }
        
        
    }
    


    
    
    
  
    

    
    
    

    

    
}
