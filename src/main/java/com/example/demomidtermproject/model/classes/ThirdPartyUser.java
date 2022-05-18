package com.example.demomidtermproject.model.classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class ThirdPartyUser extends User {

    @Column(name = "third_party_name")
    private String name;

    public ThirdPartyUser() {
    }

    public ThirdPartyUser(String username, String password, String name) {
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
