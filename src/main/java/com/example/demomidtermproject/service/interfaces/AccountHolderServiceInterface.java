package com.example.demomidtermproject.service.interfaces;

import com.example.demomidtermproject.DTO.AccountHolderDTO;
import com.example.demomidtermproject.model.classes.AccountHolder;

public interface AccountHolderServiceInterface {
    AccountHolder create(AccountHolderDTO newAccountHolder);
}
