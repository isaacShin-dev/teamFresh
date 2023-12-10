package com.example.teamfresh.service.penalty;

import com.example.teamfresh.dto.penalty.PenaltyReqDto;
import com.example.teamfresh.dto.penalty.PenaltyResDto;
import com.example.teamfresh.model.Penalty;
import com.example.teamfresh.model.Voc;
import com.example.teamfresh.repository.PenaltyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PenaltyService implements PenaltyServiceI{

    private final PenaltyRepository penaltyRepository;


    @Override
    public PenaltyResDto getPenaltyInfo(int penaltyId) {
        Penalty penaltyResDto = penaltyRepository.findById(penaltyId).orElseThrow(() -> new IllegalArgumentException("해당 VOC가 없습니다."));
        return new PenaltyResDto(penaltyResDto);
    }

    @Override
    public PenaltyResDto createPenalty(Voc voc) {
        PenaltyReqDto penaltyReqDto = PenaltyReqDto.builder()
                .voc(voc)
                .driver(voc.getDriver())
                .build();

        return new PenaltyResDto(penaltyRepository.save(penaltyReqDto.toEntity()));
    }

    @Override
    public PenaltyResDto updatePenalty(Penalty penalty) {
        //update penalty to have compensation
        penalty.setCompensation(penalty.getCompensation());
        return new PenaltyResDto(penaltyRepository.save(penalty));



    }
}
