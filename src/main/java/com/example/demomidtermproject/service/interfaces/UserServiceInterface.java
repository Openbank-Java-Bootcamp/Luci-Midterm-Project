package com.example.demomidtermproject.service.interfaces;





import com.example.demomidtermproject.model.users.User;

import java.util.List;

public interface UserServiceInterface {

    User saveUser(User user);
    List<User> getUsers();
}
