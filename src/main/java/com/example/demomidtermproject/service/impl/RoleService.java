package com.example.demomidtermproject.service.impl;



import com.example.demomidtermproject.model.users.Role;
import com.example.demomidtermproject.model.users.User;
import com.example.demomidtermproject.repository.users.RoleRepository;
import com.example.demomidtermproject.repository.users.UserRepository;
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

    public void addRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
        userRepository.save(user);
    }
}
