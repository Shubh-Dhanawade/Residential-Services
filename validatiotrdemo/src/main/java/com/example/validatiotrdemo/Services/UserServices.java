package com.example.validatiotrdemo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.validatiotrdemo.Interface.IUserServices;
import com.example.validatiotrdemo.Model.User;
import com.example.validatiotrdemo.Repos.UserRepo;

@Service
public class UserServices implements IUserServices {

    @Autowired
    UserRepo userRepo;

    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    public User createUser(User user) {

        return userRepo.save(user);
    }

    @Override
    public boolean deleteUser(long id) {

        userRepo.deleteById(id);
        return true;
    }

    @Override
    public List<User> getAllUsers() {

        return userRepo.findAll();
    }

    @Override
    public User getUserById(long id) {

        return userRepo.findById(id).get();
    }

    @Override
    public User updateUser(User user) {

        return userRepo.save(user);
    }

    @Override
    public boolean veryfyUser(User user) {
        Authentication auth = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        return auth.isAuthenticated();
    }

    @Override
    public User getUserByEmail(String email) {

        return userRepo.findByEmail(email);
    }

}
