package com.example.demomidtermproject.model.classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;

import java.util.Collection;

@Entity
public class ThirdPartyUser extends User {


    public ThirdPartyUser() {
    }

    public ThirdPartyUser(String name, String username, String password) {
        super(name, username, password);
    }


}
