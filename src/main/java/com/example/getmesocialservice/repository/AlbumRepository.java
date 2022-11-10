package com.example.getmesocialservice.repository;

import com.example.getmesocialservice.model.Album;
import com.example.getmesocialservice.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlbumRepository {

    List<Album> albumList = new ArrayList<>(List.of(
            new Album("1","Disco Tex", "Tex Cauffield", "https://www.placecage.com/g/200/300","1976"),
            new Album("2","Disco Rex 2", "Rex Cauffield", "https://www.placecage.com/g/200/300","2004"),
            new Album("3","Disco Lex 3", "Lex Luthor", "https://www.placecage.com/g/200/300","1933")
    ));

    public Album getAlbum(){
        Album album = new Album("0","Disco Tex", "Tex Cauffield", "AlbumExampleURL","1976");
        return album;
    }

    public Album saveAlbum(Album album) {
        albumList.add(album);
        return album;
    }

    public List<Album> getAllAlbums() {
        return albumList;
    }

    public Album getAlbumById(String id) {
        for(Album album: albumList){
            if(album.getid() == id){
                return album;
            }
        }
        return null;
    }

//    public Album updateAlbum(int id, Album album) {
//        for(Album a:albumList){
//            if(a.getId() == id){
//                a.setName(album.getName());
//                a.setCreatedBy(album.getCreatedBy());
//                a.setCoverPhotoUrl(album.getCoverPhotoUrl());
//                a.setDateCreated(album.getDateCreated());
//
//                return a;
//            }
//        }
//        return null;
//    }

    public Album deleteAlbum(String albumId) {
        Album deletedAlbum = null;

        for(Album u:albumList){
            if(u.getid() == albumId){
                deletedAlbum = u;
                albumList.remove(u);
                return deletedAlbum;
            }

        }
        return deletedAlbum;
    }
}