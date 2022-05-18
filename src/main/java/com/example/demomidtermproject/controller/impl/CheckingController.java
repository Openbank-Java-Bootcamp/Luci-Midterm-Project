package com.example.demomidtermproject.controller.impl;

import com.example.demomidtermproject.controller.interfaces.CheckingControllerInterface;
import com.example.demomidtermproject.model.classes.Checking;
import com.example.demomidtermproject.service.impl.CheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api-bank")
public class CheckingController implements CheckingControllerInterface {
    @Autowired
    private CheckingService checkingService;

    @GetMapping("/accounts/checking")
    @ResponseStatus(HttpStatus.OK)
    public List<Checking> getAll() {
        return checkingService.getAll();
    }
}
