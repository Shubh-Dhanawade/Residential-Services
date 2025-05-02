package com.example.validatiotrdemo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.validatiotrdemo.Interface.IPhotoPostServices;
import com.example.validatiotrdemo.Model.PhotoPost;
import com.example.validatiotrdemo.Model.User;
import com.example.validatiotrdemo.Repos.PhotoPostRepo;

@Service
public class PhotoPostServices implements IPhotoPostServices {

    @Autowired
    PhotoPostRepo photoPostRepo;

    @Override
    public PhotoPost createPhotoPost(PhotoPost photoPost) {

        return photoPostRepo.save(photoPost);
    }

    @Override
    public PhotoPost updatePhotoPost(PhotoPost photoPost) {

        return photoPostRepo.save(photoPost);
    }

    @Override
    public PhotoPost getPhotoPostById(long postid) {

        return photoPostRepo.findById(postid).get();
    }

    @Override
    public boolean deletePhotoPost(long postid) {

        photoPostRepo.deleteById(postid);
        return true;
    }

    @Override
    public List<PhotoPost> getAllPhotoPosts() {

        return photoPostRepo.findAll();
    }

    @Override
    public List<PhotoPost> getPhotoPostsByUser(User userid) {

        return photoPostRepo.findByUser(userid);
    }

}
