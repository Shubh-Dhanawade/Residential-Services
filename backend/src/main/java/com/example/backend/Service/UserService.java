package com.example.backend.Service;

import java.util.List;

import com.example.backend.Modules.User;

public interface  UserService {

  public List<User> getUser();
  public boolean deleteUser(Long id);
  public boolean updateUser(User user);
  public boolean addUser(User user);


    
}
