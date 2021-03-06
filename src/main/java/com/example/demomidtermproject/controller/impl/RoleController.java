package com.example.demomidtermproject.controller.impl;


import com.example.demomidtermproject.DTO.RoleToUserDTO;
import com.example.demomidtermproject.model.classes.Role;
import com.example.demomidtermproject.service.interfaces.RoleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-bank")
public class RoleController implements com.example.demomidtermproject.controller.interfaces.RoleControllerInterface {
    @Autowired
    private RoleServiceInterface roleService;

    @PostMapping("/roles")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveRole(@RequestBody Role role) {
        roleService.saveRole(role);
    }

    @PostMapping("/roles/addtouser")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addRoleToUser(RoleToUserDTO roleToUserDTO) {
        roleService.addRoleToUser(roleToUserDTO.getUsername(), roleToUserDTO.getRoleName());
    }
}
