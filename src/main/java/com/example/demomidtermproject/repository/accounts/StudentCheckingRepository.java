package com.example.demomidtermproject.repository.accounts;

import com.example.demomidtermproject.model.accounts.StudentChecking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCheckingRepository extends JpaRepository<StudentChecking, Long> {
}
