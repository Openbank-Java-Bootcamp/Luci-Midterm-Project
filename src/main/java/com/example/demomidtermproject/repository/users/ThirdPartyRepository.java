package com.example.demomidtermproject.repository.users;

import com.example.demomidtermproject.model.users.ThirdPartyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThirdPartyRepository extends JpaRepository<ThirdPartyUser, Long> {
}
