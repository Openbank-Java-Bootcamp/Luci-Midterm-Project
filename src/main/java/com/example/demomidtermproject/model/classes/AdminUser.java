package com.example.demomidtermproject.model.classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class AdminUser extends User {
    @Column(name = "admin_name")
    private String name;

    public AdminUser(){

    }

    public AdminUser(String username, String password, String name) {
        super(username, password);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
