package com.example.getmesocialservice.resource;


import com.example.getmesocialservice.Exception.exception;
import com.example.getmesocialservice.model.User;
import com.example.getmesocialservice.model.firebaseUser;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.ListUsersPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.getmesocialservice.service.FirebaseService;
import com.example.getmesocialservice.service.UserService;
import com.google.firebase.auth.FirebaseAuthException;

import javax.validation.Valid;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserResource {


    @Autowired
    private UserService userService;

    @Autowired
    private FirebaseService firebaseService;

    @PostMapping("/user/register")
    public User saveUser(@RequestBody @Valid User user)
    {
        return userService.saveUser(user);
    }

    @GetMapping("/firebase-users")
    public ListUsersPage getFirebaseUser() throws FirebaseAuthException {
        ListUsersPage page = FirebaseAuth.getInstance().listUsers(null);
        return page;
    }

    @GetMapping("/user")
    public User getUser(){
        return userService.getUser();

    }

    @GetMapping("/allUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") String id){
        return userService.getUserById(id);
    }

    @GetMapping("/user/email")
    public User getUserByEmail( String email){
        return userService.getUserByEmail(email);
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable("id") String id, @RequestBody User user, @RequestHeader(name ="idToken") String idToken ) throws exception,FirebaseAuthException, IOException
    {
        firebaseUser firebaseUser = firebaseService.authenticate(idToken);

        if(firebaseUser != null) {
            return userService.updateUser(id, user);
        }
        return null;
    }

    @DeleteMapping("/user")
    public User deleteUser(@RequestParam(name = "id") int id, @RequestBody User user, @RequestHeader(name ="idToken") String idToken ) throws exception,FirebaseAuthException, IOException
    {
        firebaseUser firebaseUser = firebaseService.authenticate(idToken);

        if(firebaseUser != null){
            return userService.deleteUser(id);
        }
        return null;
    }
}