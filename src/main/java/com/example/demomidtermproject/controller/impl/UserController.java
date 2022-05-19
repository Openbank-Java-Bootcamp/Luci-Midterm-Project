package com.example.demomidtermproject.controller.impl;



import com.example.demomidtermproject.controller.interfaces.UserControllerInterface;
import com.example.demomidtermproject.model.classes.User;
import com.example.demomidtermproject.repository.UserRepository;
import com.example.demomidtermproject.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-bank")
public class UserController implements UserControllerInterface {

    @Autowired
    private UserServiceInterface userService;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getById(@PathVariable(name = "id") Long id) {
        return userRepository.findById(id).get();
    }


}
