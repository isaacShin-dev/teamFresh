package com.example.teamfresh.service.compensation;

import com.example.teamfresh.dto.compensation.CompensationResDto;
import com.example.teamfresh.model.Compensation;
import com.example.teamfresh.model.Penalty;

public interface CompensationServiceI {

    CompensationResDto getCompensation(String id);

    Compensation createCompensation(int vocId, int damageAmount, Penalty penalty);

}
