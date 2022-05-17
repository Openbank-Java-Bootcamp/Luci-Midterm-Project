package com.example.demomidtermproject.controller.interfaces;

import com.example.demomidtermproject.model.classes.AccountHolder;

import java.util.List;
import java.util.Optional;

public interface AccountHolderControllerInterface {

    List<AccountHolder> getAll();

    Optional<AccountHolder> getById(long id);
}
