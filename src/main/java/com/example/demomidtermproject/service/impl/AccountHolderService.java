package com.example.demomidtermproject.service.impl;

import com.example.demomidtermproject.DTO.AccountHolderDTO;
import com.example.demomidtermproject.model.users.AccountHolder;
import com.example.demomidtermproject.model.users.Role;
import com.example.demomidtermproject.model.users.User;
import com.example.demomidtermproject.repository.accounts.AccountHolderRepository;
import com.example.demomidtermproject.repository.users.RoleRepository;
import com.example.demomidtermproject.repository.users.UserRepository;
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



    public AccountHolder create(AccountHolderDTO newAccountHolder) {
       Optional<User> userExists = Optional.ofNullable(userRepository.findByUsername(newAccountHolder.getUsername()));
       if(userExists.isEmpty()){
           PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
           newAccountHolder.setPassword(passwordEncoder.encode(newAccountHolder.getPassword()));
           AccountHolder newUser = new AccountHolder(newAccountHolder.getUsername(), newAccountHolder.getPassword(),
                   newAccountHolder.getName(), newAccountHolder.getBirthday(), newAccountHolder.getPrimaryAddress(),
                   newAccountHolder.getMailingAddress());
           newUser.setRoles(Set.of(new Role("ROLE_ACCOUNTHOLDER")));
           accountHolderRepository.save(newUser);
           return newUser;
       } else {
           throw (new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exists"));
       }
    }

    public List<AccountHolder> getAll(){
        return accountHolderRepository.findAll();
    }
}
