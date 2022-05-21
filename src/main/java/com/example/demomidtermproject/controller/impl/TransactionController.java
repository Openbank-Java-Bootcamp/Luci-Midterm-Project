package com.example.demomidtermproject.controller.impl;

import com.example.demomidtermproject.DTO.TransactionDTO;
import com.example.demomidtermproject.DTO.TransactionThirdPDTO;
import com.example.demomidtermproject.controller.interfaces.TransactionControllerInterface;
import com.example.demomidtermproject.filter.CustomAuthenticationFilter;
import com.example.demomidtermproject.model.classes.ThirdPartyUser;
import com.example.demomidtermproject.model.classes.User;
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
    public void makeTransaction(@RequestBody @Valid TransactionDTO transactionDTO){
        transactionService.makeTransaction(transactionDTO);
    }

    @PostMapping("/transactions/thirdparty-send")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sendMoneyThirdParty(@RequestBody @Valid TransactionThirdPDTO transaction, ThirdPartyUser user){
        transactionService.sendMoneyTParty(transaction, user);
    }

    @PostMapping("/transactions/thirdparty-receive")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void receiveMoneyThirdParty(@RequestBody @Valid TransactionThirdPDTO transaction, ThirdPartyUser user){
        transactionService.receiveMoneyTParty(transaction, user);
    }
}
