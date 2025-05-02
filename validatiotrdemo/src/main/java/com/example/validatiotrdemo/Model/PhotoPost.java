package com.example.validatiotrdemo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class PhotoPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postid;

    // @OneToOne
    @ManyToOne
    // @ManyToMany
    @JoinColumn(name = "userid", referencedColumnName = "id")
    private User user;

    @NotNull(message = "Image cannot be null")
    @NotBlank(message = "Image cannot be empty")
    @Column(unique = true)
    private String image;

    @NotNull(message = "Caption cannot be null")
    @NotBlank(message = "Caption cannot be empty")
    private String caption;

    public PhotoPost() {
    }

    public PhotoPost(long postid, User user, String image, String caption) {
        this.postid = postid;
        this.user = user;
        this.image = image;
        this.caption = caption;
    }

    public long getPostid() {
        return postid;
    }

    public void setPostid(long postid) {
        this.postid = postid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

}
