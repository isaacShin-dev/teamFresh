package com.example.teamfresh.dto.deliveryComp;

import com.example.teamfresh.model.DeliveryCompany;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class deliveryReqDto {
    private int id;
    private String name;
    private String phone;
    private String address;
    private String email;

    public DeliveryCompany toEntity(){
        return DeliveryCompany.builder()
                .id(id)
                .name(name)
                .phone(phone)
                .address(address)
                .email(email)
                .build();
    }

}
