package com.example.dalellegamlek_admin.model;

import java.io.Serializable;

public class User implements Serializable {

    public String email;
    public String token;

    public User(){

    }

    public User(String email, String token) {
        this.email = email;
        this.token = token;
    }
}