package com.example.demomidtermproject.service.impl;

import com.example.demomidtermproject.model.classes.StudentChecking;
import com.example.demomidtermproject.repository.StudentCheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsCheckingService {

    @Autowired
    private StudentCheckingRepository studentCheckingRepository;

    public List<StudentChecking> getAll(){
        return studentCheckingRepository.findAll();
    }
}
