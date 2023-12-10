package com.example.teamfresh.dto.voc;

import com.example.teamfresh.enums.ProcessEnum;
import com.example.teamfresh.enums.VocEnum;
import com.example.teamfresh.model.Driver;
import com.example.teamfresh.model.Voc;
import com.example.teamfresh.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VocReqDto {
    private int id;
    private Customer customer_id;
    private VocEnum fault;
    private String description;
    private Boolean isDriverFault;
    private Driver driver_id;
    private int damageAmount;
    private ProcessEnum processStatus;

    public Voc toEntity(){
        return Voc.builder()
                .id(id)
                .customer(customer_id)
                .fault(fault)
                .description(description)
                .isDriverFault(isDriverFault)
                .damageAmount(damageAmount)
                .processStatus(processStatus)
                .driver(driver_id)
                .build();
    }

    public void setDefaultValues() {
        this.processStatus = this.processStatus != null ? this.processStatus : ProcessEnum.PROCESS_TYPE_0;
        this.isDriverFault = this.isDriverFault != null ? this.isDriverFault : false;

    }





}
