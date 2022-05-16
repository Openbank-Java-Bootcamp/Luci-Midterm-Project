package com.example.demomidtermproject.model.users;

import jakarta.persistence.Entity;

@Entity
public class ThirdPartyUser extends User {

    public ThirdPartyUser() {
    }

    public ThirdPartyUser(String username, String password) {
        super(username, password);
    }
}
