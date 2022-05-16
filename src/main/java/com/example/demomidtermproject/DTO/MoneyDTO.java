package com.example.demomidtermproject.DTO;

import com.example.demomidtermproject.classes.Money;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Currency;

public class MoneyDTO {

    @NotNull
    private String currency;

    @NotNull
    private BigDecimal amount;

    public MoneyDTO() {
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Money toMoney(){
        return new Money(getAmount(), Currency.getInstance(getCurrency()));
    }
}
