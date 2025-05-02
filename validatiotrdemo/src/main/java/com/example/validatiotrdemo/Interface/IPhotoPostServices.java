package com.example.validatiotrdemo.Interface;

import java.util.List;

import com.example.validatiotrdemo.Model.PhotoPost;
import com.example.validatiotrdemo.Model.User;

public interface IPhotoPostServices {

    // simple crud operations
    public PhotoPost createPhotoPost(PhotoPost photoPost);

    public PhotoPost updatePhotoPost(PhotoPost photoPost);

    public PhotoPost getPhotoPostById(long postid);

    public boolean deletePhotoPost(long postid);

    public List<PhotoPost> getAllPhotoPosts();

    public List<PhotoPost> getPhotoPostsByUser(User userid);

}
