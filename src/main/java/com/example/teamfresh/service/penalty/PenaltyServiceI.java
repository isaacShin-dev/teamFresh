package com.example.teamfresh.service.penalty;

import com.example.teamfresh.dto.penalty.PenaltyReqDto;
import com.example.teamfresh.dto.penalty.PenaltyResDto;
import com.example.teamfresh.model.Penalty;
import com.example.teamfresh.model.Voc;

public interface PenaltyServiceI {

    PenaltyResDto getPenaltyInfo(int penaltyId);
    PenaltyResDto createPenalty(Voc voc);
    PenaltyResDto updatePenalty(Penalty penalty);


}
