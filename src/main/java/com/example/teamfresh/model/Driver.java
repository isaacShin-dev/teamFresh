package com.example.teamfresh.model;

import com.example.teamfresh.global.BaseTime;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
@Getter
public class Driver extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    String phone;

    String address;

    String email;

    // 배송 기사의 소속 회사 정보
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_company_id")
    DeliveryCompany deliveryCompany;

    // 배송 기사와 VOC 관계 설정

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderBy("id desc")
    List<Voc> vocs;  // 기사가 처리한 VOC들 관계 설정



    //setter


    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDeliveryCompany(DeliveryCompany deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public void setVocs(List<Voc> vocs) {
        this.vocs = vocs;
    }
}
