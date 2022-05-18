package com.example.demomidtermproject.controller.impl;

import com.example.demomidtermproject.controller.interfaces.StudentCheckingControllerInterface;
import com.example.demomidtermproject.model.classes.StudentChecking;
import com.example.demomidtermproject.service.impl.StudentsCheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api-bank")
public class StudentCheckingController implements StudentCheckingControllerInterface {
    @Autowired
    private StudentsCheckingService studentsCheckingService;

    @GetMapping("/accounts/student-checkings")
    public List<StudentChecking> getAll() {
        return studentsCheckingService.getAll();
    }
}
