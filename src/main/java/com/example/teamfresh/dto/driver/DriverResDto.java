package com.example.teamfresh.dto.driver;

import com.example.teamfresh.model.Driver;
import lombok.Getter;

@Getter
public class DriverResDto {
    private final int id;
    private final String name;
    private final String phone;
    private final String address;
    private final String email;

    public DriverResDto(Driver driver) {
        this.id = driver.getId();
        this.name = driver.getName();
        this.phone = driver.getPhone();
        this.address = driver.getAddress();
        this.email = driver.getEmail();

    }

    public Driver toEntity() {
        return Driver.builder()
                .id(id)
                .name(name)
                .phone(phone)
                .address(address)
                .email(email)
                .build();
    }

    @Override
    public String toString() {
        return "DriverResDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
