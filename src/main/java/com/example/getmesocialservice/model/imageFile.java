package com.example.getmesocialservice.model;

import java.util.List;

public class imageFile {

    String id;
    String fileId;
    String name;
    String path;
    String owner;

    public imageFile(String id, String fileId, String name, String path, String owner) {
        this.id = id;
        this.fileId = fileId;
        this.name = name;
        this.path = path;
        this.owner = owner;

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }


}
