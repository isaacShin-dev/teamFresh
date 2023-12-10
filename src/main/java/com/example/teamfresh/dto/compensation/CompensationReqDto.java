package com.example.teamfresh.dto.compensation;

import com.example.teamfresh.model.Compensation;
import com.example.teamfresh.model.Customer;
import com.example.teamfresh.model.Penalty;
import com.example.teamfresh.model.Voc;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompensationReqDto {
    private int id;
    private int amount;
    private Voc vocId;
    private Customer customer;

    public Compensation toEntity(){
        return Compensation.builder()
                .id(id)
                .amount(amount)
                .customer(customer)
                .voc(vocId)
                .build();
    }
}
