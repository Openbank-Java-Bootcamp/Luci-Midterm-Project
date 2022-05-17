package com.example.demomidtermproject.controller.interfaces;



import com.example.demomidtermproject.model.classes.User;

import java.util.List;

public interface UserControllerInterface {

    List<User> getUsers();
    void saveUser(User user);
    User getById(Long id);
}
