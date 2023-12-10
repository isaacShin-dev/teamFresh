package com.example.teamfresh.dto.penalty;

import com.example.teamfresh.global.BaseTime;
import com.example.teamfresh.model.Compensation;
import com.example.teamfresh.model.Driver;
import com.example.teamfresh.model.Penalty;
import com.example.teamfresh.model.Voc;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PenaltyReqDto{

    private int id;
    private Compensation compensation;
    private Voc voc;
    private Driver driver;

    public Penalty toEntity(){
        return Penalty.builder()
                .id(id)
                .voc(voc)
                .compensation(compensation)
                .driver(driver)
                .build();

    }
}
