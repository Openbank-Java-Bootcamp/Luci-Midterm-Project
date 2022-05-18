package com.example.demomidtermproject.controller.impl;

import com.example.demomidtermproject.controller.interfaces.CreditCardControllerInterface;
import com.example.demomidtermproject.model.classes.CreditCard;
import com.example.demomidtermproject.service.impl.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api-bank")
public class CreditCardController implements CreditCardControllerInterface {

    @Autowired
    private CreditCardService creditCardService;

    @GetMapping("/accounts/credit-cards")
    @ResponseStatus(HttpStatus.OK)
    public List<CreditCard> getAll(){
        return creditCardService.getAll();
    }

}
