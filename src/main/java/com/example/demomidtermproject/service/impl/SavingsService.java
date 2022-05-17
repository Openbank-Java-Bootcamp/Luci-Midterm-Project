package com.example.demomidtermproject.service.impl;

import com.example.demomidtermproject.model.classes.Savings;
import com.example.demomidtermproject.repository.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavingsService {

    @Autowired
    private SavingsRepository savingsRepository;

    public List<Savings> getAll(){
        return savingsRepository.findAll();
    }
}
