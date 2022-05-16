package com.example.demomidtermproject.DTO;

import com.example.demomidtermproject.classes.Money;

public class AccountDTO {

    private int id;

    private Money balance;

    private String accountType;

    private String primaryOwner;

    private String secondaryOwner;

    private String status;

    public AccountDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(String primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public String getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(String secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "id=" + id +
                ", balance=" + balance +
                ", accountType='" + accountType + '\'' +
                ", primaryOwner='" + primaryOwner + '\'' +
                ", secondaryOwner='" + secondaryOwner + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
