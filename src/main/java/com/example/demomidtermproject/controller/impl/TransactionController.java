package com.example.demomidtermproject.controller.impl;

import com.example.demomidtermproject.DTO.TransactionDTO;
import com.example.demomidtermproject.controller.interfaces.TransactionControllerInterface;
import com.example.demomidtermproject.filter.CustomAuthenticationFilter;
import com.example.demomidtermproject.service.impl.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-bank")
public class TransactionController implements TransactionControllerInterface {

@Autowired
    private TransactionService transactionService;

    @PostMapping("/transactions")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void makeTransaction(@RequestBody @Valid TransactionDTO transactionDTO, @AuthenticationPrincipal CustomAuthenticationFilter customAuthenticationFilter){
        transactionService.makeTransaction(transactionDTO, customAuthenticationFilter.getUsernameParameter());
    }

}
