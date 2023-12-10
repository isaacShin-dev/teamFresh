package com.example.teamfresh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import com.example.teamfresh.global.BaseTime;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;


@Entity
@Table(name = "customer")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@AllArgsConstructor
public class Customer extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    @Column(columnDefinition = "serial")
    int id;

    @JsonProperty("name")
    @Column(nullable = false)
    String name;

    @JsonProperty("address")
    @Column(nullable = false)
    String address;

    @JsonProperty("phone")
    @Column(nullable = false)
    String phone;

    @JsonProperty("email")
    @Column(nullable = false)
    String email;

    @JsonProperty("isActivated")
    @Column(nullable = false)
    @ColumnDefault("true")
    Boolean isActivated;


// Setters

        public void setId(int id) { this.id = id; }

        public void setName(String name) { this.name = name; }

        public void setAddress(String address) { this.address = address; }

        public void setPhone(String phone) { this.phone = phone; }

        public void setEmail(String email) { this.email = email; }

        public void setIsActivated(Boolean activated) {isActivated = activated;}


// Customer updator method

    public void update(Customer customer) {
        this.name = customer.getName();
        this.address = customer.getAddress();
        this.phone = customer.getPhone();
        this.email = customer.getEmail();
        this.isActivated = customer.getIsActivated();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name=" + name +
                ", address=" + address +
                ", phone=" + phone +
                ", email=" + email +
                ", isActivated=" + isActivated +
                '}';
    }



}
