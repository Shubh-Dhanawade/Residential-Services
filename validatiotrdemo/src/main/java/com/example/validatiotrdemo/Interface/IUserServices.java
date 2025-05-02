package com.example.validatiotrdemo.Interface;

import java.util.List;

import com.example.validatiotrdemo.Model.User;

public interface IUserServices {

    // simple crud operations

    public User createUser(User user);

    public User updateUser(User user);

    public User getUserById(long id);

    public boolean deleteUser(long id);

    public List<User> getAllUsers();

    // check login
    public boolean veryfyUser(User user);

    public User getUserByEmail(String email);

}
