package com.example.demomidtermproject.repository;

import com.example.demomidtermproject.model.classes.ThirdPartyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThirdPartyRepository extends JpaRepository<ThirdPartyUser, Long> {
}
