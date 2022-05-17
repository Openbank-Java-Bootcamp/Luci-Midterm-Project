package com.example.demomidtermproject.repository;

import com.example.demomidtermproject.model.classes.StudentChecking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCheckingRepository extends JpaRepository<StudentChecking, Long> {
}
