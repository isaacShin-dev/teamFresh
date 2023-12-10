package com.example.teamfresh.model;

import com.example.teamfresh.enums.ProcessEnum;
import com.example.teamfresh.global.BaseTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import com.example.teamfresh.enums.VocEnum;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "voc")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@AllArgsConstructor
@DynamicInsert
public class Voc extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    @Column(columnDefinition = "serial")
    int id;

    @JsonProperty("fault")
    @Column(name = "fault")
    @Enumerated(EnumType.STRING)
    VocEnum fault;

    @Column(name = "process_status")
    @ColumnDefault("'PROCESS_TYPE_0'")
    @Enumerated(EnumType.STRING)
    ProcessEnum processStatus;

    @JsonProperty("description")
    @Column(nullable = false)
    String description;

    @JsonProperty("damage_amount")
    @Column(nullable = false)
    int damageAmount;

    @JsonProperty("is_driver_fault")
    @Column(nullable = false)
    @ColumnDefault("false")
    Boolean isDriverFault;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id")
    Driver driver;

    @OneToOne
    @JoinColumn(name = "compensation_id")
    Compensation compensation;

    // Setters

        public void setId(int id) { this.id = id; }

        public void setCustomer(Customer customer) { this.customer = customer; }

        public void setFault(VocEnum fault) { this.fault = fault; }

        public void setDescription(String description) { this.description = description; }

        public void setDamageAmount(int damageAmount) { this.damageAmount = damageAmount; }

        public void setDriver(Driver driver) { this.driver = driver; }

        public void setCompensation(Compensation compensation) { this.compensation = compensation; }

        public void setIsDriverFault(Boolean isDriverFault) { this.isDriverFault = isDriverFault; }

        public void setProcessStatus(ProcessEnum processStatus) { this.processStatus = processStatus; }


    @Override
    public String toString() {
        return "Voc{" +
                "id=" + id +
                ", fault=" + fault +
                ", description='" + description + '\'' +
                ", damageAmount=" + damageAmount +
                ", customer=" + customer +
                ", driver=" + driver +
                '}';
    }
}
