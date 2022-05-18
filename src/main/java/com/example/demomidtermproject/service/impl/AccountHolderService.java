package com.example.demomidtermproject.service.impl;

import com.example.demomidtermproject.DTO.AccountHolderDTO;
import com.example.demomidtermproject.model.classes.AccountHolderUser;
import com.example.demomidtermproject.model.classes.Role;
import com.example.demomidtermproject.model.classes.User;
import com.example.demomidtermproject.repository.AccountHolderRepository;
import com.example.demomidtermproject.repository.RoleRepository;
import com.example.demomidtermproject.repository.UserRepository;
import com.example.demomidtermproject.service.interfaces.AccountHolderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AccountHolderService implements AccountHolderServiceInterface {

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;



    public AccountHolderUser create(AccountHolderDTO newAccountHolder) {
       Optional<User> userOptional = Optional.ofNullable(userRepository.findByUsername(newAccountHolder.getUsername()));
       if(userOptional.isEmpty()){
           PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
           newAccountHolder.setPassword(passwordEncoder.encode(newAccountHolder.getPassword()));
           AccountHolderUser newUser = new AccountHolderUser(newAccountHolder.getUsername(), newAccountHolder.getPassword(),
                   newAccountHolder.getName(), newAccountHolder.getBirthday(), newAccountHolder.getPrimaryAddress(),
                   newAccountHolder.getMailingAddress());
           newUser.setRoles(Set.of(new Role("ACCOUNTHOLDER")));
           accountHolderRepository.save(newUser);
           return newUser;
       } else {
           throw (new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exists"));
       }
    }

    public List<AccountHolderUser> getAll(){

        return accountHolderRepository.findAll();
    }
}
