package com.example.demomidtermproject;

import com.example.demomidtermproject.model.classes.Role;
import com.example.demomidtermproject.model.classes.User;
import com.example.demomidtermproject.service.impl.RoleService;
import com.example.demomidtermproject.service.impl.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class DemoMidtermProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoMidtermProjectApplication.class, args);


	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService, RoleService roleService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_ACCOUNTHOLDER"));
			userService.saveRole(new Role(null, "ROLE_THIRDPARTY"));

			userService.saveUser(new User(null, "John Doe", "john", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "James Smith", "james", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Jane Carry", "jane", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Chris Anderson", "chris", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Barbara Anderson", "barbi", "1234", new ArrayList<>()));

			roleService.addRoleToUser("john", "ROLE_ACCOUNTHOLDER");
			roleService.addRoleToUser("james", "ROLE_ADMIN");
			roleService.addRoleToUser("jane", "ROLE_USER");
			roleService.addRoleToUser("chris", "ROLE_ADMIN");
			roleService.addRoleToUser("barbi", "ROLE_THIRDPARTY");


		};
	}


}
