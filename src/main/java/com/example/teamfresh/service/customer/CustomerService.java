package com.example.teamfresh.service.customer;

import com.example.teamfresh.dto.customer.CustomerReqDto;
import com.example.teamfresh.dto.customer.CustomerResDto;
import com.example.teamfresh.model.Customer;
import com.example.teamfresh.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerService implements CustomerServiceI {

    private CustomerRepository customerRepository;

    @Override
    public CustomerResDto getCustomerById(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 고객이 없습니다. id=" + id));
        return new CustomerResDto(customer);
    }

    @Override
    public CustomerResDto createCustomer(CustomerReqDto customerReqDto) {
        Customer customer = customerReqDto.toEntity();
        Customer savedCustomer = customerRepository.save(customer);
        return new CustomerResDto(savedCustomer);
    }

    @Override
    public List<CustomerResDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(CustomerResDto::new).collect(Collectors.toList());
    }

    @Override
    public List<CustomerResDto> getAllCustomersByActive(Boolean active) {
        List<Customer> customers = customerRepository.findAllByIsActivated(active);
        return customers.stream().map(CustomerResDto::new).collect(Collectors.toList());
    }

    @Override
    public CustomerResDto updateCustomerActivation(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 고객이 없습니다. id=" + id));
        customer.setIsActivated(!customer.getIsActivated());
        Customer updatedCustomer = customerRepository.save(customer);
        return new CustomerResDto(updatedCustomer);
    }

    @Override
    public CustomerResDto updateCustomer(int id, CustomerReqDto customerReqDto) {
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 고객이 없습니다. id=" + id));
        if (customer == null || !customer.getIsActivated()) {
            return null;
        }
        customer.update(customerReqDto.toEntity());
        Customer updatedCustomer = customerRepository.save(customer);
        return new CustomerResDto(updatedCustomer);
    }
}
