package com.example.getmesocialservice.repository;

import com.example.getmesocialservice.model.User;
import com.google.firebase.auth.ExportedUserRecord;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.ListUsersPage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    List<User> userList = new ArrayList();


    public UserRepository() throws FirebaseAuthException {
    }

    public User getUser(){
        User user = userList.get(userList.size()-1);
        return user;
    }

    public User saveUser(User user) {
            //user.setUserId(userList.size()+1);
            userList.add(user);
            return user;
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public User getUserById(String id) {
        for(User user: userList){
            if(user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    public User getUserByEmail(String email) {
        for(User user: userList){
            if(user.getemail().equals(email)){
                return user;
            }
        }
        return null;
    }

    public User updateUser(String id, User user) {
        for(User u:userList){
            if(u.getId().equals(id)){
                u.setName(user.getName());
                u.setemail(user.getemail());
                u.setProfilePhotoUrl(user.getProfilePhotoUrl());

                saveUser(u);

                return u;
            }
        }
        return null;
    }

    public User deleteUser(int id) {
        User deletedUser = null;

        for(User u:userList){
            if(u.getId().equals(id)){
                deletedUser = u;
                userList.remove(u);
                return deletedUser;
            }
        }
        return deletedUser;
    }

    public User setProfilePhoto(String id, String profilePhoto)
    {
        for(User u:userList){
            if(u.getId().equals(id)){
                u.setProfilePhotoUrl(profilePhoto);

                return u;
            }
        }
        return null;


    }
}