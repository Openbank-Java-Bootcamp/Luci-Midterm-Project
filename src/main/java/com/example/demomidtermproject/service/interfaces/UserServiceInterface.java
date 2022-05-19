package com.example.demomidtermproject.service.interfaces;





import com.example.demomidtermproject.model.classes.Role;
import com.example.demomidtermproject.model.classes.User;

import java.util.List;

public interface UserServiceInterface {

    User saveUser(User user);
    List<User> getUsers();

    Role saveRole(Role role);
}
