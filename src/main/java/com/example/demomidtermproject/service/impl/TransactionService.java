package com.example.demomidtermproject.service.impl;

import com.example.demomidtermproject.DTO.AccountHolderDTO;
import com.example.demomidtermproject.DTO.TransactionDTO;
import com.example.demomidtermproject.DTO.TransactionThirdPDTO;
import com.example.demomidtermproject.model.classes.*;
import com.example.demomidtermproject.model.interfaces.AccountSecretKey;
import com.example.demomidtermproject.model.interfaces.AccountStatus;
import com.example.demomidtermproject.repository.*;
import com.example.demomidtermproject.service.interfaces.TransactionServiceInterface;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public abstract class TransactionService implements TransactionServiceInterface {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CheckingRepository checkingRepository;

    @Autowired
    private StudentCheckingRepository studentCheckingRepository;

    @Autowired
    private SavingsRepository savingsRepository;

    public void makeTransaction(TransactionDTO transactionDTO) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
        } else {
            String username = principal.toString();
        }
        Optional<Account> optionalSender = accountRepository.findById(transactionDTO.getSendingAccountId());
        Optional<Account> optionalOwner = accountRepository.findById(transactionDTO.getHoldingAccountId());
        if(optionalSender.isEmpty() || optionalOwner.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Accounts not found");
        }
        //Relationship between account and transaction
        Account senderAccount = (Account) Hibernate.unproxy(accountRepository.findById(transactionDTO.getSendingAccountId()));
        Account ownerAccount = (Account) Hibernate.unproxy(accountRepository.findById(transactionDTO.getHoldingAccountId()));

        //Check the role and the owner
        if(!senderAccount.getPrimaryOwner().getId().equals(transactionDTO.getHoldingAccountId()) && (senderAccount.getSecondaryOwner() == null)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The account has another owner");
        }else if(ownerAccount.getSecondaryOwner() == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The owner does not exit");
        }

        //Check sufficient funds
        if(senderAccount.getBalance().getAmount().compareTo(transactionDTO.getAmount()) < 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You haven't money enough");
        }
        transactionRepository.save(new Transaction(senderAccount, ownerAccount, transactionDTO.getAmount()));

        //Save money and apply PenaltyFee
        ownerAccount.getBalance().increaseAmount(transactionDTO.getAmount());
        senderAccount.getBalance().decreaseAmount(transactionDTO.getAmount());
        accountRepository.save(ownerAccount);

        if (senderAccount instanceof Checking) {
            Checking checking = (Checking) senderAccount;
            checking.applyPenaltyFee(checking.getMinimumBalance());
            checkingRepository.save(checking);
        }
        if (senderAccount instanceof Savings){
            Savings savings = (Savings) senderAccount;
            savings.applyPenaltyFee(savings.getMinimumBalance());
            savingsRepository.save(savings);
        }
        accountRepository.save(senderAccount);
    }

    public void sendMoneyTParty(TransactionThirdPDTO transactionThirdPDTO, User thirdPUser) {

        int thirdParty = (int) thirdPUser.getRoles().stream().filter(x -> x.getName().equals("ROLE_THIRDPARTY")).count();
        if(thirdParty != 1) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Not allowed to make this transaction");
        }
        Optional<Account> optionalAccount = accountRepository.findById(transactionThirdPDTO.getAccountId());
        if(optionalAccount.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Account doesn't exist");
        }
        Account transactionAccount = (Account) Hibernate.unproxy(accountRepository.findById(transactionThirdPDTO.getAccountId()));
        if(!(transactionAccount instanceof AccountSecretKey)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        AccountSecretKey accountSecretKey = (AccountSecretKey) transactionAccount;
        if(!accountSecretKey.getSecretKey().equals(transactionThirdPDTO.getSecretKey())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Incorrect Secret Key");
        }
        transactionAccount.getBalance().increaseAmount(transactionThirdPDTO.getAmount());
        accountRepository.save(transactionAccount);
        transactionRepository.save(new Transaction(transactionAccount, transactionThirdPDTO.getAmount()));

    }


    public void receiveMoneyTParty(TransactionThirdPDTO transactionThirdPDTO, User thirdPUser) {
        int thirdParty = (int) thirdPUser.getRoles().stream().filter(x -> x.getName().equals("ROLE_THIRDPARTY")).count();
        if(thirdParty != 1) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Not allowed to make this transaction");
        }
        Optional<Account> optionalAccount = accountRepository.findById(transactionThirdPDTO.getAccountId());
        if(optionalAccount.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Account doesn't exist");
        }
        Account transactionAccount = (Account) Hibernate.unproxy(accountRepository.findById(transactionThirdPDTO.getAccountId()));
        if(transactionAccount.getBalance().getAmount().compareTo(transactionThirdPDTO.getAmount())< 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not enough funds for transaction");
        }
        transactionAccount.getBalance().decreaseAmount(transactionThirdPDTO.getAmount());
        accountRepository.save(transactionAccount);
        transactionRepository.save(new Transaction(transactionAccount, transactionThirdPDTO.getAmount()));

        if(transactionAccount instanceof Checking) {
            Checking checking = (Checking) transactionAccount;
            checking.applyPenaltyFee(checking.getMinimumBalance());
            checkingRepository.save(checking);
        }
        if (transactionAccount instanceof Savings) {
            Savings savings = (Savings) transactionAccount;
            savings.applyPenaltyFee(savings.getMinimumBalance());
            savingsRepository.save(savings);
        }
        accountRepository.save(transactionAccount);
    }
}
