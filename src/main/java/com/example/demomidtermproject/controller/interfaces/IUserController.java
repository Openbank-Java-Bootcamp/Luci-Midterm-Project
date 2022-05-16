package com.example.demomidtermproject.controller.interfaces;



import com.example.demomidtermproject.model.users.User;

import java.util.List;

public interface IUserController {

    List<User> getUsers();
    void saveUser(User user);
}
