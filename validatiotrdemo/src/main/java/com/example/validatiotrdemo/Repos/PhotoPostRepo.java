package com.example.validatiotrdemo.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.validatiotrdemo.Model.PhotoPost;
import com.example.validatiotrdemo.Model.User;

@Repository
public interface PhotoPostRepo extends JpaRepository<PhotoPost, Long> {
    public List<PhotoPost> findByUser(User userid);

}
