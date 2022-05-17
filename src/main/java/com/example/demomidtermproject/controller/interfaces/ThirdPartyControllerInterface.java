package com.example.demomidtermproject.controller.interfaces;

import com.example.demomidtermproject.model.classes.ThirdPartyUser;

import java.util.List;
import java.util.Optional;

public interface ThirdPartyControllerInterface {

    List<ThirdPartyUser> getAll();
    Optional<ThirdPartyUser> getById(long id);
}
