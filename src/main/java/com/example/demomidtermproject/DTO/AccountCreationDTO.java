package com.example.demomidtermproject.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class AccountCreationDTO {
    @Min(value = 1, message = "")
    private long primaryOwner;

    private long secondaryOwner;

    @Valid
    @NotNull(message = "Balance is required")
    private MoneyDTO balance;

    @NotNull(message = "Accounts require a secret key")
    private String secretKey;

    @NotNull(message = "Choose the type of account")
    private String accountType;

    private BigDecimal creditCardInterestRate = new BigDecimal("0.2");

    private BigDecimal creditCardLimit = new BigDecimal("100");

    private BigDecimal savingsInterestRate = new BigDecimal("0.0025");

    private BigDecimal savingsMinimumBalance = new BigDecimal("1000");

    public AccountCreationDTO() {
    }

    public AccountCreationDTO(long primaryOwner, long secondaryOwner, MoneyDTO balance, String secretKey, String accountType, BigDecimal creditCardInterestRate, BigDecimal creditCardLimit) {
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.balance = balance;
        this.secretKey = secretKey;
        this.accountType = accountType;
        this.creditCardInterestRate = creditCardInterestRate;
        this.creditCardLimit = creditCardLimit;
    }

    public long getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(long primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public long getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(long secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public MoneyDTO getBalance() {
        return balance;
    }

    public void setBalance(MoneyDTO balance) {
        this.balance = balance;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getCreditCardInterestRate() {
        return creditCardInterestRate;
    }

    public void setCreditCardInterestRate(BigDecimal creditCardInterestRate) {
        this.creditCardInterestRate = creditCardInterestRate;
    }

    public BigDecimal getCreditCardLimit() {
        return creditCardLimit;
    }

    public void setCreditCardLimit(BigDecimal creditCardLimit) {
        this.creditCardLimit = creditCardLimit;
    }

    public BigDecimal getSavingsInterestRate() {
        return savingsInterestRate;
    }

    public void setSavingsInterestRate(BigDecimal savingsInterestRate) {
        this.savingsInterestRate = savingsInterestRate;
    }

    public BigDecimal getSavingsMinimumBalance() {
        return savingsMinimumBalance;
    }

    public void setSavingsMinimumBalance(BigDecimal savingsMinimumBalance) {
        this.savingsMinimumBalance = savingsMinimumBalance;
    }
}
