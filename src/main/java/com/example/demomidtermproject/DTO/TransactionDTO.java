package com.example.demomidtermproject.DTO;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class TransactionDTO{

    @DecimalMin(value = "0", message = "Transaction must be greater than 0")
    private BigDecimal amount;

    @NotNull(message = "Id of receiver account is needed")
    private long holdingAccountId;

    @NotNull(message = "Id of sender account is needed")
    private long sendingAccountId;

    public TransactionDTO(BigDecimal amount, long holdingAccountId, long sendingAccountId) {
        this.amount = amount;
        this.holdingAccountId = holdingAccountId;
        this.sendingAccountId = sendingAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public long getHoldingAccountId() {
        return holdingAccountId;
    }

    public void setHoldingAccountId(long holdingAccountId) {
        this.holdingAccountId = holdingAccountId;
    }

    public long getSendingAccountId() {
        return sendingAccountId;
    }

    public void setSendingAccountId(long sendingAccountId) {
        this.sendingAccountId = sendingAccountId;
    }
}
