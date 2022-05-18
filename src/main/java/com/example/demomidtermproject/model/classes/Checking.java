package com.example.demomidtermproject.model.classes;

import com.example.demomidtermproject.enums.Status;
import com.example.demomidtermproject.model.interfaces.AccountSecretKey;
import com.example.demomidtermproject.model.interfaces.AccountStatus;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Entity
public class Checking extends Account implements AccountStatus, AccountSecretKey {

    @NotNull(message = "Checking account require secret key")
    private String secretKey;

    private LocalDateTime lastMonthlyMaintenanceFee;

    private final BigDecimal monthlyMaintenanceFee = new BigDecimal("12");

    private final BigDecimal minimumBalance = new BigDecimal("250");

    private Status status = Status.ACTIVE;

    public Checking() {
    }

    public Checking(AccountHolderUser primaryOwner, AccountHolderUser secondaryOwner, Money balance, String secretKey, Status status){
        super(primaryOwner, secondaryOwner, balance);
        this.secretKey = secretKey;
        this.status = status;
        this.lastMonthlyMaintenanceFee = LocalDateTime.now();
    }

    public Checking(AccountHolderUser primaryOwner, Money balance, String secretKey, Status status){
        super(balance, primaryOwner);
        this.secretKey = secretKey;
        this.status = status;
        this.lastMonthlyMaintenanceFee = LocalDateTime.now();
    }

    public Checking(AccountHolderUser primaryOwner, AccountHolderUser secondaryOwner, Money balance, String secretKey){
        super(primaryOwner, secondaryOwner, balance);
        this.secretKey = secretKey;
        this.lastMonthlyMaintenanceFee = LocalDateTime.now();
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public LocalDateTime getLastMonthlyMaintenanceFee() {
        return lastMonthlyMaintenanceFee;
    }

    public void setLastMonthlyMaintenanceFee(LocalDateTime lastMonthlyMaintenanceFee) {
        this.lastMonthlyMaintenanceFee = lastMonthlyMaintenanceFee;
    }

    public BigDecimal getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void applyMonthlyMaintenanceFee(){
        int months = Period.between(LocalDate.from(lastMonthlyMaintenanceFee), LocalDate.now()).getMonths();
        for(int i = 0; i < months; i++){
            getBalance().decreaseAmount(monthlyMaintenanceFee);
        }
        lastMonthlyMaintenanceFee = lastMonthlyMaintenanceFee.plusMonths(months);
        setLastMonthlyMaintenanceFee(lastMonthlyMaintenanceFee.plusMonths(months));
    }

    @Override
    public String toString() {
        return "Checking{" +
                "secret key='" + secretKey + '\'' +
                ", monthly maintenance fee=" + monthlyMaintenanceFee +
                ", minimum balance=" + minimumBalance +
                ", status=" + status +
                '}';
    }
}
