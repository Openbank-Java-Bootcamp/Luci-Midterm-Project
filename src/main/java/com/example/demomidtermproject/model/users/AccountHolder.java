package com.example.demomidtermproject.model.users;

import com.example.demomidtermproject.classes.Address;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Collection;

@Entity
public class AccountHolder extends User{
    @Column(name = "user_name")
    private String name;

    private LocalDate birthday;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "city")),
            @AttributeOverride(name = "street", column = @Column(name = "street")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "postal_code"))
    })
    private Address primaryAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "mailing_city")),
            @AttributeOverride(name = "street", column = @Column(name = "mailing_street")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "mailing_postal_code"))
    })
    private Address mailingAddress;

    public AccountHolder() {
    }

    public AccountHolder(String name, LocalDate birthday, Address primaryAddress, Address mailingAddress) {
        this.name = name;
        this.birthday = birthday;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
    }

    public AccountHolder(String name, LocalDate birthday, Address primaryAddress) {
        this.name = name;
        this.birthday = birthday;
        this.primaryAddress = primaryAddress;
    }

    public AccountHolder(String username, String password, String name, LocalDate birthday, Address primaryAddress) {
        super(password, username);
        this.name = name;
        this.birthday = birthday;
        this.primaryAddress = primaryAddress;
    }

    public AccountHolder(String username, String password, String name, LocalDate birthday, Address primaryAddress, Address mailingAddress) {
        super(password, username);
        this.name = name;
        this.birthday = birthday;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "AccountHolder{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", primary address=" + primaryAddress +
                ", mailing address=" + mailingAddress +
                '}';
    }
}
