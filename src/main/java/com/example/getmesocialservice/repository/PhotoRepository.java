package com.example.getmesocialservice.repository;

import com.example.getmesocialservice.model.Photo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PhotoRepository {
    //(String id, String albumId, String photoUrl, String createdBy, String dateCreated)
    List<Photo> photoList = new ArrayList<>(List.of(
            new Photo("1","AlbumId1","www.placecage.com/200/300", "Tex Cauffield","1976"),
            new Photo("2","AlbumId2","www.placecage.com/400/400", "Rex Cauffield","2004"),
            new Photo("3","AlbumId3","www.placecage.com/300/300", "Lex Luthor","1933")
    ));

    public Photo getPhoto(){
        Photo photo = photoList.get(photoList.size()-1);
        return photo;
    }

    public Photo savePhoto(Photo photo) {
//        photo.setId(photoList.size() +1);
        photoList.add(photo);
        return photo;
    }

    public List<Photo> getAllPhotos() {return photoList;}

    public Photo getPhotoById(String id) {
        for(Photo photo:photoList){
            if(photo.getId() == id){
                return photo;
            }
        }
        return null;
    }

    public Photo deletePhoto(String id) {
        Photo deletedPhoto = null;

        for(Photo p:photoList){
            if(p.getId() == id) {
                deletedPhoto = p;
                photoList.remove(p);
                return deletedPhoto;
            }
        }
        return deletedPhoto;
    }
}