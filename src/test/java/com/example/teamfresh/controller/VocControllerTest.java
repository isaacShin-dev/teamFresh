package com.example.teamfresh.controller;

import com.example.teamfresh.dto.customer.CustomerReqDto;
import com.example.teamfresh.dto.customer.CustomerResDto;
import com.example.teamfresh.dto.voc.VocReqDto;
import com.example.teamfresh.dto.voc.VocResDto;
import com.example.teamfresh.model.Customer;
import com.example.teamfresh.repository.CustomerRepository;
import com.example.teamfresh.service.customer.CustomerService;
import com.example.teamfresh.service.voc.VocService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class VocControllerTest {


    @Autowired
    private VocService vocService;

    @Autowired
    private CustomerService customerService;
    @Autowired
    CustomerRepository customerRepository;

    private VocController vocController;


    @BeforeEach
    void setUp() {
        this.vocController = new VocController(vocService);
    }


//    @Test
    @Rollback(false)
    void createComplaint() {
        VocReqDto vocReqDto = new VocReqDto();
        vocReqDto.setDescription("Test Description");

//        VocResDto res = vocController.createComplaint(vocReqDto, 1, 1);
//
//        Assert.isTrue(res.getDescription().equals("Test Description"), "Response is not successful");








    }
}