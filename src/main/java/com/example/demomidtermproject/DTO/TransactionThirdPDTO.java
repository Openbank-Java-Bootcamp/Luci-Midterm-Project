package com.example.demomidtermproject.DTO;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class TransactionThirdPDTO {

    @DecimalMin(value = "0", message = "Transaction must be greater than 0")
    BigDecimal amount;

    @NotNull(message = "Id of receiver account is needed")
    private long accountId;

    @NotNull(message = "Secret key is needed")
    private String secretKey;

    public TransactionThirdPDTO() {
    }

    public TransactionThirdPDTO(BigDecimal amount, long accountId, String secretKey) {
        this.amount = amount;
        this.accountId = accountId;
        this.secretKey = secretKey;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public String toString() {
        return "TransactionThirdPDTO{" +
                "amount=" + amount +
                ", accountId=" + accountId +
                ", secretKey='" + secretKey + '\'' +
                '}';
    }
}
