package com.example.demomidtermproject.service.impl;



import com.example.demomidtermproject.model.classes.Role;
import com.example.demomidtermproject.model.classes.User;
import com.example.demomidtermproject.repository.RoleRepository;
import com.example.demomidtermproject.repository.UserRepository;
import com.example.demomidtermproject.service.interfaces.RoleServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleService implements RoleServiceInterface {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;


    public Role saveRole(Role role) {
        log.info("Saving a new role {} to the database", role.getRole());
        return roleRepository.save(role);
    }

    public void addRoleToUser(String username, String role) {
        User user = userRepository.findByUsername(username);
        Role role1 = roleRepository.findByRole(role);
        user.getRoles().add(role1);
        userRepository.save(user);
    }
}
