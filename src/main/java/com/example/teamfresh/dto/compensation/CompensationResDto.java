package com.example.teamfresh.dto.compensation;

import com.example.teamfresh.model.Compensation;
import com.example.teamfresh.model.Customer;
import com.example.teamfresh.model.Voc;
import lombok.Getter;

@Getter
public class CompensationResDto {
    private final int id;
    private final int amount;
    private Voc voc;
    private final Customer customer;

    public CompensationResDto(Compensation compensation) {
        this.id = compensation.getId();
        this.amount = compensation.getAmount();
        this.voc = compensation.getVoc();
        this.customer = compensation.getVoc().getCustomer();
    }

    public Compensation toEntity() {
        return Compensation.builder()
                .id(id)
                .amount(amount)
                .voc(voc)
                .customer(customer)
                .build();
    }

    @Override
    public String toString() {
        return "CompensationResDto{" +
                "id=" + id +
                ", amount=" + amount +
                ", customer=" + customer +
                ", voc=" + voc +
                '}';
    }
}
