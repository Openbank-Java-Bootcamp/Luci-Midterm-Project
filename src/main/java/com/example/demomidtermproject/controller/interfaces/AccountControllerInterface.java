package com.example.demomidtermproject.controller.interfaces;

import com.example.demomidtermproject.model.classes.Account;

import java.util.List;

public interface AccountControllerInterface {
    List<Account> getAll();

    Account getById(long id);

}
