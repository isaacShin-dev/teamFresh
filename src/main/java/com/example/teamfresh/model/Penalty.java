package com.example.teamfresh.model;

import com.example.teamfresh.global.BaseTime;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
@Getter
public class Penalty extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @JoinColumn(name = "voc_id")
    @OneToOne
    Voc voc;

    @JoinColumn(name = "driver_id")
    @ManyToOne()
    Driver driver;

    @OneToOne()
    @JoinColumn(name = "compensation_id")
    Compensation compensation;


    //setter
    public void setId(int id) {
        this.id = id;
    }

    public void setVoc(Voc voc) {
        this.voc = voc;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setCompensation(Compensation compensation) {
        this.compensation = compensation;
    }

}
