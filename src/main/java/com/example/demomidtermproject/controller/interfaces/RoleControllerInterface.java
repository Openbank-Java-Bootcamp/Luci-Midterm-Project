package com.example.demomidtermproject.controller.interfaces;


import com.example.demomidtermproject.DTO.RoleToUserDTO;
import com.example.demomidtermproject.model.classes.Role;

public interface RoleControllerInterface {

    void saveRole(Role role);
    void addRoleToUser(RoleToUserDTO roleToUserDTO);
}
