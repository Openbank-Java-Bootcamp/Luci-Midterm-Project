package com.example.demomidtermproject.service.interfaces;

import com.example.demomidtermproject.DTO.AccountHolderDTO;
import com.example.demomidtermproject.model.users.AccountHolder;

public interface AccountHolderServiceInterface {
    AccountHolder create(AccountHolderDTO newAccountHolder);
}
