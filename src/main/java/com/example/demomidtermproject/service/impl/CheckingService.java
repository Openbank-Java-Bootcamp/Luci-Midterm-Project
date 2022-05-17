package com.example.demomidtermproject.service.impl;

import com.example.demomidtermproject.model.classes.Checking;
import com.example.demomidtermproject.repository.CheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckingService {

    @Autowired
    private CheckingRepository checkingRepository;

    public List<Checking> getAll(){
        return checkingRepository.findAll();
    }
}
