package com.example.demomidtermproject.controller.impl;

import com.example.demomidtermproject.enums.Status;
import com.example.demomidtermproject.model.classes.*;
import com.example.demomidtermproject.repository.AccountHolderRepository;
import com.example.demomidtermproject.repository.SavingsRepository;
import com.example.demomidtermproject.repository.StudentCheckingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.of;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class SavingsControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private SavingsRepository savingsRepository;
    @Autowired
    private AccountHolderRepository accountHolderRepository;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Address address1 = new Address("Madrid", "Plaza de los Cubos", 28030);
        Address address2 = new Address("Toledo", "Zocodover", 45500);
        AccountHolderUser accountHolderUser1 = new AccountHolderUser("Lucia Sanchez", "luci", "12224", LocalDate.of(2000, 10, 1), address1, address2);
        AccountHolderUser accountHolderUser2 = new AccountHolderUser("Pepe Perez", "pepe", "12224", LocalDate.of(2001, 12, 12), address1, address2);
        accountHolderRepository.saveAll(List.of(accountHolderUser1, accountHolderUser2));

        Savings savings = new Savings(accountHolderUser1, accountHolderUser2, new Money(new BigDecimal("2000")),  "12142");
        Savings savings2 = new Savings(accountHolderUser2, accountHolderUser1, new Money(new BigDecimal("3000")),  "12142");

        savingsRepository.save(savings);
    }

    @AfterEach
    void tearDown() {
        savingsRepository.deleteAll();
        accountHolderRepository.deleteAll();
    }

    @Test
    void getAll() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/bank-api/accounts/saving-accounts"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Lucia Sanchez"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Zocodover"));
    }
}