package com.example.teamfresh.controller;

import com.example.teamfresh.global.CustomResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.teamfresh.dto.customer.CustomerReqDto;
import com.example.teamfresh.dto.customer.CustomerResDto;
import com.example.teamfresh.service.customer.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{id}/")
    public CustomResponse<?> getCustomerById(@PathVariable int id) {
        return new CustomResponse<>(CustomResponse.StatusCode.SUCCESS, customerService.getCustomerById(id));
    }

    @GetMapping("/")
    public CustomResponse<?> getAllCustomers(@RequestParam(required = false) Boolean active) {
        if (active != null) {
            return new CustomResponse<>(CustomResponse.StatusCode.SUCCESS, customerService.getAllCustomersByActive(active));
        }
        return new CustomResponse<>(CustomResponse.StatusCode.SUCCESS, customerService.getAllCustomers());
    }

    @PostMapping("/")
    public CustomResponse<?> createCustomer(@RequestBody CustomerReqDto customerReqDto) {
        return new CustomResponse<>(CustomResponse.StatusCode.SUCCESS, customerService.createCustomer(customerReqDto));
    }

    @PatchMapping("/{id}/")
    public CustomResponse<CustomerResDto> updateCustomerActivation(@PathVariable int id) {
        return new CustomResponse<>(CustomResponse.StatusCode.SUCCESS, customerService.updateCustomerActivation(id));
    }

    @PutMapping("/{id}/")
    public CustomResponse<CustomerResDto> updateCustomer(@PathVariable int id, @RequestBody CustomerReqDto customerReqDto) {
        return new CustomResponse<>(CustomResponse.StatusCode.SUCCESS, customerService.updateCustomer(id, customerReqDto));
    }
}
