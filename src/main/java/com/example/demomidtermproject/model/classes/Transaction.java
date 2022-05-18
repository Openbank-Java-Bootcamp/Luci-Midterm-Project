package com.example.demomidtermproject.model.classes;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sending_account_id")
    private Account sendingId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "holding_account_id")
    private Account holdingId;

    private LocalDateTime transactionDate = LocalDateTime.now();

    @DecimalMin(value = "0", message = "Transaction must be greater than 0")
    private BigDecimal amount;

    public Transaction() {
    }

    public Transaction(Account sendingId, BigDecimal amount) {
        this.sendingId = sendingId;
        this.amount = amount;
    }

    public Transaction(Account sendingId, Account holdingId, BigDecimal amount) {
        this.sendingId = sendingId;
        this.holdingId = holdingId;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getSendingId() {
        return sendingId;
    }

    public void setSendingId(Account sendingId) {
        this.sendingId = sendingId;
    }

    public Account getHoldingId() {
        return holdingId;
    }

    public void setHoldingId(Account holdingId) {
        this.holdingId = holdingId;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", sendingId=" + sendingId +
                ", holdingId=" + holdingId +
                ", transactionDate=" + transactionDate +
                ", amount=" + amount +
                '}';
    }
}
