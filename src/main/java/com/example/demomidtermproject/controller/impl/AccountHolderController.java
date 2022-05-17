package com.example.demomidtermproject.controller.impl;

import com.example.demomidtermproject.DTO.AccountHolderDTO;
import com.example.demomidtermproject.controller.interfaces.AccountHolderControllerInterface;
import com.example.demomidtermproject.model.classes.AccountHolder;
import com.example.demomidtermproject.repository.AccountHolderRepository;
import com.example.demomidtermproject.service.impl.AccountHolderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api-bank")
public class AccountHolderController implements AccountHolderControllerInterface {
    @Autowired
    private AccountHolderService accountHolderService;

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @GetMapping("/users/account-holders")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountHolder> getAll() {
        return accountHolderService.getAll();
    }

    @GetMapping("/users/account-holders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<AccountHolder> getById(@PathVariable long id) {
        return accountHolderRepository.findById(id);
    }

    @PostMapping("/users/account-holders")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder create(@RequestBody @Valid AccountHolderDTO accountHolderDTO){
        return accountHolderService.create(accountHolderDTO);
    }
}
