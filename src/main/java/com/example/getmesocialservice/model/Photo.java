package com.example.getmesocialservice.model;

import com.example.getmesocialservice.validation.*;

import java.util.ArrayList;
import java.util.List;

public class Photo {
    public String id;
    public String albumId;
    private String photoUrl;
    @ValidCreatedBy
    private String createdBy;
    private String dateCreated;

    public List<Comment> comments;

    List<Comment> commentListPlaceholder = new ArrayList<>(List.of(
            new Comment("1",id,"First Message", "Pa Strong","Jan 22 2022"),
            new Comment("2",id,"Second Message", "Pa Strong","Jan 23 2022"),
            new Comment("3",id,"Third Message", "Baby Strong","Jan 29 2022")
    ));
    public Photo(String id, String albumId, String photoUrl, String createdBy, String dateCreated,List<Comment> comments) {
        this.id = id;
        this.albumId = albumId;
        this.photoUrl = photoUrl;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
        this.comments = commentListPlaceholder;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
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


}