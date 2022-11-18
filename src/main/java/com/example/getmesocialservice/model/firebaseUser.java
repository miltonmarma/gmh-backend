package com.example.getmesocialservice.model;


import com.google.firebase.auth.ListUsersPage;

public class firebaseUser {

    private String uid;
    private String name;
    private String email;

    private com.google.firebase.auth.ListUsersPage ListUsersPage;

    public firebaseUser(String uid, String name, String email) {
        this.uid = uid;
        this.name = name;
        this.email = email;
    }


    public ListUsersPage getListUsers(){return ListUsersPage;}

    public String getUid(){
        return uid;
    }
    public void setUid(String uid){
        this.uid = uid;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
}