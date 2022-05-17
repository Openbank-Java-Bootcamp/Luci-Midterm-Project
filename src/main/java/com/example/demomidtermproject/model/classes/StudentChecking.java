package com.example.demomidtermproject.model.classes;

import com.example.demomidtermproject.enums.Status;
import com.example.demomidtermproject.model.interfaces.AccountSecretKey;
import com.example.demomidtermproject.model.interfaces.AccountStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

@Entity
public class StudentChecking extends Account implements AccountStatus, AccountSecretKey {

    @NotNull(message = "Student accounts require a secret key")
    private String secretKey;

    @Enumerated(value = EnumType.STRING)
    private Status status = Status.ACTIVE;

    public StudentChecking() {
    }

    public StudentChecking(AccountHolder primaryOwner, AccountHolder secondaryOwner, Money balance, Status status) {
        super(primaryOwner, secondaryOwner, balance);
        this.status = status;
    }

    public StudentChecking(AccountHolder primaryOwner, Money balance, Status status) {
        super(balance, primaryOwner);
        this.status = status;
    }

    public StudentChecking(AccountHolder primaryOwner, Money balance, Status status, String secretKey) {
        super(balance, primaryOwner);
        this.status = status;
        this.secretKey = secretKey;
    }

    public StudentChecking(AccountHolder primaryOwner, AccountHolder secondaryOwner, Money balance, String secretKey) {
        super(primaryOwner, secondaryOwner, balance);
        this.secretKey = secretKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StudentChecking{" +
                "secret key='" + secretKey + '\'' +
                ", status=" + status +
                '}';
    }
}
