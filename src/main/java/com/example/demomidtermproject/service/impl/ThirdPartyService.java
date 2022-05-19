package com.example.demomidtermproject.service.impl;

import com.example.demomidtermproject.model.classes.Role;
import com.example.demomidtermproject.model.classes.ThirdPartyUser;
import com.example.demomidtermproject.model.classes.User;
import com.example.demomidtermproject.repository.RoleRepository;
import com.example.demomidtermproject.repository.ThirdPartyRepository;
import com.example.demomidtermproject.repository.UserRepository;
import com.example.demomidtermproject.service.interfaces.ThirdPartyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.Set;

@Service
public class ThirdPartyService implements ThirdPartyServiceInterface {
    @Autowired
    private ThirdPartyRepository thirdPartyRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ThirdPartyUser create(ThirdPartyUser newThirdParty) {
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByUsername(newThirdParty.getUsername()));
        if(optionalUser.isEmpty()){
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            newThirdParty.setPassword(passwordEncoder.encode(newThirdParty.getPassword()));
            ThirdPartyUser thirdPartyUser = new ThirdPartyUser(newThirdParty.getName(),
                    newThirdParty.getUsername(), newThirdParty.getPassword());
            thirdPartyUser.setRoles(newThirdParty.getRoles());
            thirdPartyRepository.save(thirdPartyUser);
            return thirdPartyUser;
        }else {
            throw (new ResponseStatusException(HttpStatus.BAD_REQUEST));
        }
    }
}
