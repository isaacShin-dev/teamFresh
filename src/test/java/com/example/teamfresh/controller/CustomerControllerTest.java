package com.example.teamfresh.controller;

import com.example.teamfresh.dto.customer.CustomerReqDto;
import com.example.teamfresh.global.CustomResponse;
import com.example.teamfresh.model.Customer;
import com.example.teamfresh.service.voc.VocService;
import com.example.teamfresh.service.customer.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@SpringBootTest
@Transactional
class CustomerControllerTest {

    @Autowired
    private CustomerService customerService;
    private CustomerController customerController;


    @BeforeEach
    void setUp() {
        this.customerController = new CustomerController(customerService);
    }


    @Test
    @Rollback(false)
    void testCreateCustomer() {
        CustomResponse<?> response = null;
        for (int i = 0; i < 10; i++) {
            CustomerReqDto customerReqDto = new CustomerReqDto();
            customerReqDto.setName("Test Customer " + i);
            customerReqDto.setAddress("Test Address " + i);
            customerReqDto.setPhone("Test Phone " + i + "-1234-5678");
            customerReqDto.setEmail("Test Email " + i + "@test.com");
            customerReqDto.setIsActivated(true);

            response = customerController.createCustomer(customerReqDto);


        }
    }

}