package com.example.demomidtermproject.model.classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Entity
public class CreditCard extends Account {

    @DecimalMin(value = "0.1", message = "Interest rate must be above 0.1")
    @Column(precision = 32, scale = 4)
    private BigDecimal interestRate;

    @DecimalMin(value = "100", message = "Limit must be above 100")
    @DecimalMax(value = "100000", message = "Limit must be below 100000")
    private BigDecimal creditLimit;

    private LocalDateTime lastInterestRateApplied;

    private LocalDateTime interestAdded;

    public CreditCard() {
    }

    public CreditCard(AccountHolder primaryOwner, AccountHolder secondaryOwner, Money balance, BigDecimal interestRate, BigDecimal creditLimit) {
        super(primaryOwner, secondaryOwner, balance);
        setInterestRate(interestRate);
        setCreditLimit(creditLimit);
        this.lastInterestRateApplied = LocalDateTime.now();
    }

    public CreditCard(Money balance, AccountHolder primaryOwner, BigDecimal interestRate, BigDecimal creditLimit) {
        super(balance, primaryOwner);
        setInterestRate(interestRate);
        setCreditLimit(creditLimit);
        this.lastInterestRateApplied = LocalDateTime.now();
    }

    public CreditCard(Money balance, AccountHolder primaryOwner) {
        super(balance, primaryOwner);
        setInterestRate(interestRate);
        setCreditLimit(creditLimit);
        this.lastInterestRateApplied = LocalDateTime.now();
    }

    public BigDecimal getInterestRate() {

        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate == null ? new BigDecimal("0.2") : interestRate;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit == null ? new BigDecimal("1000") : creditLimit;
    }

    public LocalDateTime getLastInterestRateApplied() {
        return lastInterestRateApplied;
    }

    public void setLastInterestRateApplied(LocalDateTime lastInterestRateApplied) {
        this.lastInterestRateApplied = lastInterestRateApplied;
    }

    public LocalDateTime getInterestAdded() {
        return interestAdded;
    }

    public void setInterestAdded(LocalDateTime interestAdded) {
        this.interestAdded = interestAdded;
    }

    public void applyMonthlyInterestRate(){
        int months = Period.between(LocalDate.from(lastInterestRateApplied), LocalDate.now()).getMonths();
        BigDecimal year = new BigDecimal(12);
        BigDecimal interestApplyMonthly = interestRate.divide(year, RoundingMode.HALF_EVEN);

        for(int i = 0; i < months; i++){
            BigDecimal interest = getBalance().getAmount().multiply(interestApplyMonthly);
            Money balance = getBalance();
            balance.increaseAmount(interest.setScale(2, RoundingMode.HALF_EVEN));
            setBalance(balance);
            setLastInterestRateApplied(LocalDateTime.now());
        }
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "interest rate=" + interestRate +
                ", credit limit=" + creditLimit +
                ", interest added=" + interestAdded +
                '}';
    }
}
