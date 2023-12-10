package com.example.teamfresh.model;

import com.example.teamfresh.global.BaseTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Compensation extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @JsonProperty("amount")
    int amount;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "voc_id")
    Voc voc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    Customer customer;

}
