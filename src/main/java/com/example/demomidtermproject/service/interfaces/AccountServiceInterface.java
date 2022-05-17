package com.example.demomidtermproject.service.interfaces;

import com.example.demomidtermproject.DTO.AccountCreationDTO;
import com.example.demomidtermproject.enums.Status;
import com.example.demomidtermproject.model.classes.Account;

public interface AccountServiceInterface {
    Account create(AccountCreationDTO newAccount);

    Account getById(long id);

    Account changeStatus(Long id, Status status);

}
