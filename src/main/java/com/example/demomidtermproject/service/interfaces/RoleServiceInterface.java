package com.example.demomidtermproject.service.interfaces;


import com.example.demomidtermproject.model.users.Role;

public interface RoleServiceInterface {
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
}
