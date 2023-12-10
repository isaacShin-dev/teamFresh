package com.example.teamfresh.dto.driver;

import com.example.teamfresh.model.DeliveryCompany;
import com.example.teamfresh.model.Driver;
import com.example.teamfresh.model.Voc;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DriverReqDto {

    private int id;
    private String name;
    private String phone;
    private String address;
    private String email;
    private DeliveryCompany deliveryCompany;
    List<Voc> vocs;

    public Driver toEntity(){
        return Driver.builder()
                .id(id)
                .name(name)
                .phone(phone)
                .address(address)
                .email(email)
                .deliveryCompany(deliveryCompany)
                .build();
    }
}
