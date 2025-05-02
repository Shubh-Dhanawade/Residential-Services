package com.example.validatiotrdemo.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be empty")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @NotNull(message = "Email cannot be null")
    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email must be a valid email")
    // Email must be unique
    @Column(unique = true)
    private String email;

    @NotNull(message = "Password cannot be null")
    @NotBlank(message = "Password cannot be empty")
    // @Size(min = 6, max = 50, message = "Password must be between 6 and 50
    // characters")
    // @Pattern(regexp =
    // "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,50}$",
    // message = "Password must contain 1 uppercase, 1 lowercase, 1 number, 1
    // special character")
    // @JsonIgnore
    private String password;

    @NotNull(message = "Phone cannot be null")
    @NotBlank(message = "Phone cannot be empty")
    @Size(min = 10, max = 10, message = "Phone must be 10 characters")
    private String phone;

    @NotNull(message = "Address cannot be null")
    @NotBlank(message = "Address cannot be empty")
    @Size(min = 10, max = 100, message = "Address must be between 10 and 100 characters")
    private String address;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<PhotoPost> photoPost;

    private String role;

    public User() {
    }

    public User(long id, String name, String email, String password, String phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;

    }

    public User(long id,
            @NotNull(message = "Name cannot be null") @NotBlank(message = "Name cannot be empty") @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters") String name,
            @NotNull(message = "Email cannot be null") @NotBlank(message = "Email cannot be empty") @Email(message = "Email must be a valid email") String email,
            @NotNull(message = "Password cannot be null") @NotBlank(message = "Password cannot be empty") String password,
            @NotNull(message = "Phone cannot be null") @NotBlank(message = "Phone cannot be empty") @Size(min = 10, max = 10, message = "Phone must be 10 characters") String phone,
            @NotNull(message = "Address cannot be null") @NotBlank(message = "Address cannot be empty") @Size(min = 10, max = 100, message = "Address must be between 10 and 100 characters") String address,
            List<PhotoPost> photoPost, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.photoPost = photoPost;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<PhotoPost> getPhotoPost() {
        return photoPost;
    }

    public void setPhotoPost(List<PhotoPost> photoPost) {
        this.photoPost = photoPost;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
