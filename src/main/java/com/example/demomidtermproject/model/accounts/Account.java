package com.example.demomidtermproject.model.accounts;

import com.example.demomidtermproject.classes.Money;
import com.example.demomidtermproject.model.users.AccountHolder;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Embedded
    private Money balance;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "primary_owner")
    private AccountHolder primaryOwner;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "secondary_owner")
    private AccountHolder secondaryOwner;

    private LocalDateTime creationDate = LocalDateTime.now();

    private final BigDecimal penaltyFee = new BigDecimal("40");

    private BigDecimal maxAmountIn24Hours;

    public Account() {
    }

    public Account(Money balance, AccountHolder primaryOwner) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
    }

    public Account(AccountHolder primaryOwner, AccountHolder secondaryOwner, Money balance) {
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public AccountHolder getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(AccountHolder primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public AccountHolder getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(AccountHolder secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    public BigDecimal getMaxAmountIn24Hours() {
        return maxAmountIn24Hours;
    }

    public void setMaxAmountIn24Hours(BigDecimal maxAmountIn24Hours) {
        this.maxAmountIn24Hours = maxAmountIn24Hours;
    }

    public void applyPenaltyFee(BigDecimal minimumBalance){
        if(balance.getAmount().compareTo(minimumBalance) < 0){
            balance.decreaseAmount(penaltyFee);
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", primary owner=" + primaryOwner +
                ", secondary owner=" + secondaryOwner +
                ", creation date=" + creationDate +
                ", penalty fee=" + penaltyFee +
                ", max amount in 24 hours=" + maxAmountIn24Hours +
                '}';
    }
}
