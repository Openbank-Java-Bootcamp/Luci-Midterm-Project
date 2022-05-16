package com.example.demomidtermproject.service.impl;

import com.example.demomidtermproject.DTO.AccountCreationDTO;
import com.example.demomidtermproject.enums.Status;
import com.example.demomidtermproject.model.accounts.*;
import com.example.demomidtermproject.model.users.AccountHolder;
import com.example.demomidtermproject.model.users.User;
import com.example.demomidtermproject.repository.accounts.*;
import com.example.demomidtermproject.service.interfaces.AccountServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
@Service
public class AccountService implements AccountServiceInterface {
    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @Autowired
    private SavingsRepository savingsRepository;

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private StudentCheckingRepository studentCheckingRepository;

    @Autowired
    private CheckingRepository checkingRepository;

    @Autowired
    private AccountRepository accountRepository;


    public Account create(AccountCreationDTO newAccount) {
        AccountHolder primaryOwner = accountHolderRepository.findById(newAccount.getPrimaryOwner())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, ("User with id " + newAccount.getPrimaryOwner() + " does not exist")));
        AccountHolder secondaryOwner = accountHolderRepository.findById(newAccount.getSecondaryOwner()).orElse(null);

        switch (newAccount.getAccountType()){
            case "savings":
                if(newAccount.getSavingsInterestRate().compareTo(new BigDecimal("0.5")) > 0){
                    throw (new ResponseStatusException(HttpStatus.BAD_REQUEST, "Interest rate must be lower than 0.5"));
                }
                if(newAccount.getSavingsMinimumBalance().compareTo(new BigDecimal("100")) < 0 || newAccount.getSavingsMinimumBalance().compareTo(new BigDecimal("1000")) > 0){
                    throw (new ResponseStatusException(HttpStatus.BAD_REQUEST, "Savings account minimum balance must be between 100-1000"));
                }
                Savings savings = new Savings(newAccount.getBalance().toMoney(), primaryOwner, secondaryOwner, newAccount.getSecretKey(), newAccount.getSavingsInterestRate(),
                        newAccount.getSavingsMinimumBalance());
                if(savings.getBalance().getAmount().compareTo(savings.getMinimumBalance()) < 0) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Savings account balance must be above " + newAccount.getSavingsMinimumBalance() + " " + savings.getBalance().getCurrency());
                }

                return savingsRepository.save(savings);

            case "credit":
                if(newAccount.getCreditCardInterestRate().compareTo(new BigDecimal("0.2")) > 0 || newAccount.getCreditCardInterestRate().compareTo(new BigDecimal("0.1")) < 0) {
                    throw (new ResponseStatusException(HttpStatus.BAD_REQUEST, "Interest rate must be between 0.1 " + "and 0.2" ));
                }
                if(newAccount.getCreditCardLimit().compareTo(new BigDecimal("100000")) > 0 || newAccount.getCreditCardLimit().compareTo(new BigDecimal("100")) < 0){
                    throw (new ResponseStatusException(HttpStatus.BAD_REQUEST, "Credit card limit must be between 100 and 100000"));
                }
                CreditCard creditCard = new CreditCard(primaryOwner, secondaryOwner, newAccount.getBalance().toMoney(), newAccount.getCreditCardInterestRate(), newAccount.getCreditCardLimit());

                if(creditCard.getBalance().getAmount().compareTo(creditCard.getCreditLimit()) > 0){
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Credit card account balance must be below " + newAccount.getCreditCardLimit() + " " + creditCard.getBalance().getCurrency());

                }
                return creditCardRepository.save(creditCard);

            case "checking":
                int age = Period.between(primaryOwner.getBirthday(), LocalDate.now()).getYears();
                if(age < 24){
                    StudentChecking studentChecking = new StudentChecking(primaryOwner, secondaryOwner, newAccount.getBalance().toMoney(), newAccount.getSecretKey());
                    return studentCheckingRepository.save(studentChecking);
                }
                Checking checking = new Checking(primaryOwner, secondaryOwner, newAccount.getBalance().toMoney(), newAccount.getSecretKey());
                if(checking.getBalance().getAmount().compareTo(checking.getMinimumBalance()) < 0){
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Checking account balance must be above "
                    + checking.getMinimumBalance() + " " + checking.getBalance().getCurrency());
                }
                return checkingRepository.save(checking);
        }
        throw new IllegalArgumentException("A valid account type is required: savings, credit or checking");
    }

    //TODO:
    @Override
    public Account getById(long id) {
        return null;
    }

    @Override
    public List<Account> getAllUserAccounts(long userId, User user) {
        return null;
    }

    @Override
    public Account changeStatus(Long id, Status status) {
        return null;
    }
}
