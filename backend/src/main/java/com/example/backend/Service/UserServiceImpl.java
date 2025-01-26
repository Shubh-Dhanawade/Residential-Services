package com.example.backend.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backend.Modules.User;
import com.example.backend.Repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{

    private UserRepo userrp;
    

    public UserServiceImpl(UserRepo userrp) {
        this.userrp = userrp;
    }


    @Override
    public List<User> getUser() {
        return userrp.findAll();
    }


    @Override
    public boolean deleteUser(Long id) {

        try {
            userrp.deleteById(id);

        return true;
        } catch (Exception e) {
        return false;
        }
    }


    @Override
    public boolean updateUser(User user) {
        try {
            userrp.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }


    @Override
    public boolean addUser(User user) {
        try {
            userrp.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }


   

   
    
}
