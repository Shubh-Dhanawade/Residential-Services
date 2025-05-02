    package com.example.validatiotrdemo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.validatiotrdemo.Model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    public User findByEmail(String email);

}
