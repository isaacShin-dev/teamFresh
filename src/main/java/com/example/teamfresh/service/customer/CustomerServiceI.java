package com.example.teamfresh.service.customer;

import com.example.teamfresh.dto.customer.CustomerReqDto;
import com.example.teamfresh.dto.customer.CustomerResDto;
import java.util.List;

public interface CustomerServiceI {
    CustomerResDto createCustomer(CustomerReqDto customerReqDto);
    CustomerResDto getCustomerById(int id);
    CustomerResDto updateCustomerActivation(int id);
    CustomerResDto updateCustomer(int id, CustomerReqDto customerReqDto);

    List<CustomerResDto> getAllCustomers();
    List<CustomerResDto> getAllCustomersByActive(Boolean active);
}
