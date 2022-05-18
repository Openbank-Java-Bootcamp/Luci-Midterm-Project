package com.example.demomidtermproject.controller.interfaces;

import com.example.demomidtermproject.model.classes.AccountHolderUser;

import java.util.List;
import java.util.Optional;

public interface AccountHolderControllerInterface {

    List<AccountHolderUser> getAll();

    Optional<AccountHolderUser> getById(long id);
}
