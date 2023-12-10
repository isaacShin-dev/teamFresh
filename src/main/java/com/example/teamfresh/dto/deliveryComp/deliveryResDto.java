package com.example.teamfresh.dto.deliveryComp;

import com.example.teamfresh.model.DeliveryCompany;
import lombok.*;

@Getter
public class deliveryResDto {
    private final int id;
    private final String name;
    private final String phone;
    private final String address;
    private final String email;

    public deliveryResDto(DeliveryCompany deliveryCompanyDto) {
        this.id = deliveryCompanyDto.getId();
        this.name = deliveryCompanyDto.getName();
        this.phone = deliveryCompanyDto.getPhone();
        this.address = deliveryCompanyDto.getAddress();
        this.email = deliveryCompanyDto.getEmail();
    }

    @Override
    public String toString() {
        return "deliveryReqDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }



}
