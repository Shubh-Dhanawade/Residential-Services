package com.example.backend.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.backend.Modules.User;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
     @Query(value = "select * from user where email=?1 and password=?2",nativeQuery=true)
    public User login(String email, String password);
    
}
