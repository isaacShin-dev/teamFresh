package com.example.teamfresh.dto.customer;


import com.example.teamfresh.model.Voc;
import com.example.teamfresh.model.Customer;
import lombok.Getter;

import java.util.List;

@Getter
public class CustomerResDto {
    private final int id;
    private final String name;
    private final String address;
    private final String phone;
    private final String email;
    private final Boolean isActivated;

    public CustomerResDto(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.address = customer.getAddress();
        this.phone = customer.getPhone();
        this.email = customer.getEmail();
        this.isActivated = customer.getIsActivated();
    }

    public Customer toEntity() {
        return Customer.builder()
                .id(id)
                .name(name)
                .address(address)
                .phone(phone)
                .email(email)
                .isActivated(isActivated)
                .build();
    }

    @Override
    public String toString() {
        return "CustomerResDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", isActivated=" + isActivated +
                '}';
    }
}
