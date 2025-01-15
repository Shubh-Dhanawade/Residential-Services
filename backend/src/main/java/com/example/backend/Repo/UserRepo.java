package com.example.backend.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.Modules.User;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    
}
