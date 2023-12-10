package com.example.teamfresh.model;

import com.example.teamfresh.global.BaseTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@AllArgsConstructor
@Builder
public class DeliveryCompany extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    int id;

    @JsonProperty("name")
    String name;

    @JsonProperty("phone")
    String phone;

    @JsonProperty("address")
    String address;

    @JsonProperty("email")
    String email;

    @OneToMany(mappedBy = "deliveryCompany", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderBy("id desc")
    List<Driver> drivers;  // 업체에 속한 기사들 관계 설정

    }
