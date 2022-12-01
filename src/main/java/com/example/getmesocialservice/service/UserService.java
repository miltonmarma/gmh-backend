package com.example.getmesocialservice.service;

import com.example.getmesocialservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.getmesocialservice.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(){
        return userRepository.getUser();
    }

    public User saveUser(User user) {
        return userRepository.saveUser(user);
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User getUserById(String id) {
        return userRepository.getUserById(id);
    }

    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    public User updateUser(String id, User user) {
        return userRepository.updateUser(id,user);
    }

    public User deleteUser(int id) {
        return userRepository.deleteUser(id);
    }

    public User setProfilePhoto(String profilePhoto){ return userRepository.setProfilePhoto(profilePhoto); }
}