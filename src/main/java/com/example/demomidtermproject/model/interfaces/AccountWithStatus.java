package com.example.demomidtermproject.model.interfaces;

import com.example.demomidtermproject.enums.Status;

public interface AccountWithStatus {

    Status getStatus();

    void setStatus(Status status);
}
