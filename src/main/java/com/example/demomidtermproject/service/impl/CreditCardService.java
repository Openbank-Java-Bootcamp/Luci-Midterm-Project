package com.example.demomidtermproject.service.impl;

import com.example.demomidtermproject.model.classes.CreditCard;
import com.example.demomidtermproject.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    public List<CreditCard> getAll(){
        return creditCardRepository.findAll();
    }
}
