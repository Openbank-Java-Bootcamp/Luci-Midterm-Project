package com.example.demomidtermproject.repository.accounts;

import com.example.demomidtermproject.model.accounts.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
