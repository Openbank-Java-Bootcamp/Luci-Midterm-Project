package com.example.demomidtermproject.controller.impl;

import com.example.demomidtermproject.controller.interfaces.ThirdPartyControllerInterface;
import com.example.demomidtermproject.model.classes.ThirdPartyUser;
import com.example.demomidtermproject.repository.ThirdPartyRepository;
import com.example.demomidtermproject.service.impl.ThirdPartyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-bank")
public class ThirdPartyController implements ThirdPartyControllerInterface {

    @Autowired
    private ThirdPartyService thirdPartyService;

    @Autowired
    private ThirdPartyRepository thirdPartyRepository;

    @GetMapping("/users/third-parties")
    @ResponseStatus(HttpStatus.OK)
    public List<ThirdPartyUser> getAll() {
        return thirdPartyRepository.findAll();
    }

    @GetMapping("/users/third-parties/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ThirdPartyUser> getById(@PathVariable(name = "id") long id) {
        return thirdPartyRepository.findById(id);
    }

    @PostMapping("/users/third-parties")
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdPartyUser create(@RequestBody @Valid ThirdPartyUser thirdPartyUser){
        return thirdPartyService.create(thirdPartyUser);
    }
}
