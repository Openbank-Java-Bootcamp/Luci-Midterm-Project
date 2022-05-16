package com.example.demomidtermproject.DTO;

import com.example.demomidtermproject.classes.Address;

import java.time.LocalDate;

public class AccountHolderDTO {

    private int id;

    private String name;

    private String username;

    private LocalDate birthday;

    private Address primaryAddress;

    private Address mailingAddress;

    private String password;

    public AccountHolderDTO() {
    }

    public AccountHolderDTO(int id, String name, String username, LocalDate birthday, Address primaryAddress, Address mailingAddress, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.birthday = birthday;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
        this.password = password;
    }

    public AccountHolderDTO(String name, String username, LocalDate birthday, Address primaryAddress, Address mailingAddress, String password) {
        this.name = name;
        this.username = username;
        this.birthday = birthday;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
