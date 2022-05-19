package com.example.demomidtermproject.repository;

import com.example.demomidtermproject.model.classes.AccountHolderUser;
import com.example.demomidtermproject.model.classes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolderUser, Long> {
    User findByUsername(String username);
}
