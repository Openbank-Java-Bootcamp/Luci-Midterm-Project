package com.example.demomidtermproject.model.classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class AdminUser extends User {

    public AdminUser(){

    }

    public AdminUser(String name, String username, String password) {
        super(name, username, password);
    }
}
