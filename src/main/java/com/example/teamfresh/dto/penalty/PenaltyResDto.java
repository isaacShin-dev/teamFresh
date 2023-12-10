package com.example.teamfresh.dto.penalty;

import com.example.teamfresh.model.Compensation;
import com.example.teamfresh.model.Driver;
import com.example.teamfresh.model.Penalty;
import com.example.teamfresh.model.Voc;
import lombok.Getter;

@Getter
public class PenaltyResDto {
    private final int id;
    private final Driver driver;
    private final Voc voc;

    private Compensation compensation = null;

    public PenaltyResDto(Penalty penalty) {
        this.id = penalty.getId();
        this.driver = penalty.getDriver();
        this.voc = penalty.getVoc();
        this.compensation = penalty.getCompensation();
    }

    public Penalty toEntity() {
        return Penalty.builder()
                .id(id)
                .driver(driver)
                .voc(voc)
                .compensation(compensation)
                .build();
    }

    @Override
    public String toString() {
        return "PenaltyResDto{" +
                "id=" + id +
                ", driver=" + driver +
                ", voc=" + voc +
                ", compensation=" + compensation +
                '}';
    }
}
