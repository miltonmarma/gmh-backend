package com.example.getmesocialservice.model;

//import org.hibernate.*;
import com.example.getmesocialservice.validation.*;
import com.example.getmesocialservice.model.Photo;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

public class Album {

    public String id;
//    @Length(max = 10)
    private String name;

    @ValidCreatedBy
    private String createdBy;
    public List<Photo> coverPhotos;
    private String dateCreated;
    List<Photo> photoListPlaceholder = new ArrayList<>(List.of(
            new Photo("1",id,"www.placecage.com/200/300", "Tex Cauffield","1976"),
            new Photo("2",id,"www.placecage.com/400/400", "Rex Cauffield","2004"),
            new Photo("3",id,"www.placecage.com/300/300", "Lex Luthor","1933")
    ));
    public Album(String id, String name, String createdBy, List<Photo> coverPhotos, String dateCreated) {
        this.id = id;
        this.name = name;
        this.createdBy = createdBy;
        this.coverPhotos = photoListPlaceholder;
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

    public List<Photo> getCoverPhotos() {
        return coverPhotos;
    }

    public void setCoverPhotos(List<Photo> coverPhotos) {
        this.coverPhotos = coverPhotos;
    }
}