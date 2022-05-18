package com.example.demomidtermproject.model.classes;

import com.example.demomidtermproject.enums.Status;
import com.example.demomidtermproject.model.interfaces.AccountSecretKey;
import com.example.demomidtermproject.model.interfaces.AccountStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Entity
public class Savings extends Account implements AccountSecretKey, AccountStatus {

    @NotNull(message = "Checking accounts require a secret key")
    private String secretKey;

    private LocalDateTime lastInterestRate;

    @Enumerated(value = EnumType.STRING)
    private Status status = Status.ACTIVE;

    @DecimalMax(value = "0.5", message = "Savings account's interest rate must be below 0.5")
    @DecimalMin(value = "0", message = "Interest rate can not have a negative value")
    @Column(precision = 32, scale = 4)
    private BigDecimal interestRate;

    @DecimalMax(value = "1000", message = "Savings' balance must be below 1000")
    @DecimalMin(value = "100", message = "Savings' balance must be above 100")
    private BigDecimal minimumBalance;

    public Savings() {
    }

    public Savings(AccountHolderUser primaryOwner, AccountHolderUser secondaryOwner, Money balance, String secretKey, Status status, BigDecimal interestRate, BigDecimal minimumBalance) {
        super(primaryOwner, secondaryOwner, balance);
        this.secretKey = secretKey;
        this.status = status;
        setInterestRate(interestRate);
        setMinimumBalance(minimumBalance);
        this.lastInterestRate = LocalDateTime.now();
    }

    public Savings(Money balance, AccountHolderUser primaryOwner, String secretKey, Status status, BigDecimal interestRate, BigDecimal minimumBalance) {
        super(balance, primaryOwner);
        this.secretKey = secretKey;
        this.status = status;
        setInterestRate(interestRate);
        setMinimumBalance(minimumBalance);
        this.lastInterestRate = LocalDateTime.now();
    }

    public Savings(Money balance, AccountHolderUser primaryOwner, AccountHolderUser secondaryOwner, String secretKey, BigDecimal interestRate, BigDecimal minimumBalance) {
        super(primaryOwner, secondaryOwner, balance);
        this.secretKey = secretKey;
        setInterestRate(interestRate);
        setMinimumBalance(minimumBalance);
        this.lastInterestRate = LocalDateTime.now();
    }

    public Savings(AccountHolderUser primaryOwner, AccountHolderUser secondaryOwner, Money balance, String secretKey) {
        super(primaryOwner, secondaryOwner, balance);
        this.secretKey = secretKey;
        setInterestRate(interestRate);
        setMinimumBalance(minimumBalance);
        this.lastInterestRate = LocalDateTime.now();
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public LocalDateTime getLastInterestRate() {
        return lastInterestRate;
    }

    public void setLastInterestRate(LocalDateTime lastInterestRate) {
        this.lastInterestRate = lastInterestRate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate == null ? new BigDecimal("0.0025") : interestRate;
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance == null ? new BigDecimal("1000") : minimumBalance;
    }

    public void applyAnualInterestRate(){
        int years = Period.between(LocalDate.from(lastInterestRate), LocalDate.now()).getYears();
        for(int i = 0; i < years; i++){
            BigDecimal interest = getBalance().getAmount().multiply(interestRate);
            Money balance = getBalance();
            balance.increaseAmount(interest.setScale(2, RoundingMode.HALF_EVEN));
            setBalance(balance);
            setLastInterestRate(LocalDateTime.now());
        }
    }

    @Override
    public String toString() {
        return "Savings{" +
                "secret key='" + secretKey + '\'' +
                ", status=" + status +
                ", interest rate=" + interestRate +
                ", minimum balance=" + minimumBalance +
                '}';
    }
}
