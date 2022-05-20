package com.example.demomidtermproject.repository;

import com.example.demomidtermproject.model.classes.AccountHolderUser;
import com.example.demomidtermproject.model.classes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolderUser, Long> {
    Optional<User> findByUsername(String username);
}
