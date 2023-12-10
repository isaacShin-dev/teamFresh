package com.example.teamfresh.dto.customer;

import com.example.teamfresh.model.Voc;
import com.example.teamfresh.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerReqDto {

    private int id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private Voc voc;
    private Boolean isActivated;


    public Customer toEntity(){
        return Customer.builder()
                .id(id)
                .name(name)
                .address(address)
                .phone(phone)
                .email(email)
                .isActivated(isActivated)
                .build();
    }
}
