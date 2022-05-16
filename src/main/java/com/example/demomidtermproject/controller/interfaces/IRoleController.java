package com.example.demomidtermproject.controller.interfaces;


import com.example.demomidtermproject.DTO.RoleToUserDTO;
import com.example.demomidtermproject.model.users.Role;

public interface IRoleController {

    void saveRole(Role role);
    void addRoleToUser(RoleToUserDTO roleToUserDTO);
}
