package com.example.demomidtermproject.service.interfaces;

import com.example.demomidtermproject.DTO.AccountCreationDTO;
import com.example.demomidtermproject.DTO.AccountHolderDTO;
import com.example.demomidtermproject.enums.Status;
import com.example.demomidtermproject.model.accounts.Account;
import com.example.demomidtermproject.model.users.AccountHolder;
import com.example.demomidtermproject.model.users.User;

import java.util.List;

public interface AccountServiceInterface {
    Account create(AccountCreationDTO newAccount);

    Account getById(long id);

    List<Account> getAllUserAccounts(long userId, User user);

    Account changeStatus(Long id, Status status);

}
