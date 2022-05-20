package com.example.demomidtermproject.service.interfaces;

import com.example.demomidtermproject.DTO.TransactionDTO;
import com.example.demomidtermproject.DTO.TransactionThirdPDTO;
import com.example.demomidtermproject.model.classes.User;

public interface TransactionServiceInterface {

    void makeTransaction(TransactionDTO transactionDTO, User user);

   // void sendMoneyTParty(TransactionThirdPDTO transactionThirdPDTO, User thirdPUser);

  //  void receiveMoneyTParty(TransactionThirdPDTO transactionThirdPDTO, User thirdPUser);
}
