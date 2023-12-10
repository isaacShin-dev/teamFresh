package com.example.teamfresh.dto.voc;

import com.example.teamfresh.enums.ProcessEnum;
import com.example.teamfresh.model.Compensation;
import com.example.teamfresh.model.Voc;
import com.example.teamfresh.model.Customer;
import lombok.Getter;

@Getter
public class VocResDto {
    private final int id;
    private final Customer customer_id;
    private final String description;
    private final Compensation compensation;
    private String fault;
    private Boolean isDriverFault;
    private final ProcessEnum processStatus;

    public VocResDto(Voc voc) {
        this.id = voc.getId();
        this.customer_id = voc.getCustomer();
        this.description = voc.getDescription();
        this.compensation = voc.getCompensation();
        this.processStatus = voc.getProcessStatus();
        if(voc.getFault() != null){
            this.fault = voc.getFault().toString();
        }
        if(voc.getIsDriverFault() != null){
            this.isDriverFault = voc.getIsDriverFault();
        }
    }

    @Override
    public String toString() {
        return "VocResDto{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", fault='" + fault + '\'' +
                ", description='" + description + '\'' +
                ", compensation=" + compensation +
                '}';
    }
}
