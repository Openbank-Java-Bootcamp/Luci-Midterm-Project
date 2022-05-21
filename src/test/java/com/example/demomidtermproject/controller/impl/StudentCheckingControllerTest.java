package com.example.demomidtermproject.controller.impl;

import com.example.demomidtermproject.enums.Status;
import com.example.demomidtermproject.model.classes.AccountHolderUser;
import com.example.demomidtermproject.model.classes.Address;
import com.example.demomidtermproject.model.classes.Money;
import com.example.demomidtermproject.model.classes.StudentChecking;
import com.example.demomidtermproject.repository.AccountHolderRepository;
import com.example.demomidtermproject.repository.StudentCheckingRepository;
import com.example.demomidtermproject.service.impl.StudentsCheckingService;
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
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class StudentCheckingControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private StudentCheckingRepository studentAccountRepository;
    @Autowired
    private AccountHolderRepository accountHolderRepository;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Address address1 = new Address("Madrid", "Plaza de los Cubos", 28030);
        Address address2 = new Address("Toledo", "Zocodover", 45500);
        AccountHolderUser accountHolderUser1 = new AccountHolderUser("Lucia Sanchez", "luci", "12224",
                LocalDate.of(2000, 10, 1), address1, address2);
        accountHolderRepository.save(accountHolderUser1);

        StudentChecking studentAccount = new StudentChecking(accountHolderUser1,
                new Money(new BigDecimal("2000")), Status.ACTIVE, "12142");

        studentAccountRepository.save(studentAccount);
    }

    @AfterEach
    void tearDown() {
        studentAccountRepository.deleteAll();
        accountHolderRepository.deleteAll();
    }

    @Test
    void getAll() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/api-bank/accounts/student-checkings"))
                .andExpect(status().isOk())
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Lucia Sanchez"));
    }
}