package com.example.demomidtermproject.controller.impl;

import com.example.demomidtermproject.DTO.AccountCreationDTO;
import com.example.demomidtermproject.controller.interfaces.AccountControllerInterface;
import com.example.demomidtermproject.model.classes.Account;
import com.example.demomidtermproject.repository.AccountRepository;
import com.example.demomidtermproject.service.impl.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-bank")
public class AccountController implements AccountControllerInterface {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @GetMapping("/accounts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account getById(@PathVariable(name = "id") long id) {
        return accountService.getById(id);
    }

    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public Account create(@RequestBody @Valid AccountCreationDTO accountCreationDTO) {
        return accountService.create(accountCreationDTO);
    }
}
