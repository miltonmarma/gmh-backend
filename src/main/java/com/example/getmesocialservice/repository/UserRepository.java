package com.example.getmesocialservice.repository;

import com.example.getmesocialservice.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    List<User> userList = new ArrayList();

    public User getUser(){
        User user = new User( "Tom","example@hotmail.com", "0", "ExampleURL");
        return user;
    }

    public User saveUser(User user) {
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

    public User updateUser(String id, User user) {
        for(User u:userList){
            if(u.getId().equals(id)){
                u.setName(user.getName());
                u.setemail(user.getemail());
                u.setProfilePhotoUrl(user.getProfilePhotoUrl());

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
}