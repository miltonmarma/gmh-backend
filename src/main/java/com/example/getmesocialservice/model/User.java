package com.example.getmesocialservice.model;

import javax.validation.constraints.*;

public class User {

    private String id;
    private String name;

    @Email
    private String email;
    @NotEmpty
    private String profilePhotoUrl;

    public User(String name, String email, String id, String profilePhotoUrl) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.profilePhotoUrl = profilePhotoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }
}
