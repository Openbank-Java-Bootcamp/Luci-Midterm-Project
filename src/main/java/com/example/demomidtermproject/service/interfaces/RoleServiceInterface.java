package com.example.demomidtermproject.service.interfaces;


import com.example.demomidtermproject.model.classes.Role;

public interface RoleServiceInterface {
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
}
