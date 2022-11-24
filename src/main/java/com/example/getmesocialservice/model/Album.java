package com.example.getmesocialservice.model;

//import org.hibernate.*;
import com.example.getmesocialservice.validation.*;

import javax.validation.constraints.*;

public class Album {

    private String id;
//    @Length(max = 10)
    private String name;

    @ValidCreatedBy
    private String createdBy;
    public String coverPhotoUrl;
    private String dateCreated;

    public Album(String id, String name, String createdBy, String coverPhotoUrl, String dateCreated) {
        this.id = id;
        this.name = name;
        this.createdBy = createdBy;
        this.coverPhotoUrl = coverPhotoUrl;
        this.dateCreated = dateCreated;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverPhotoUrl() {
        return coverPhotoUrl;
    }

    public void setCoverPhotoUrl(String coverPhotoUrl) {
        this.coverPhotoUrl = coverPhotoUrl;
    }
}