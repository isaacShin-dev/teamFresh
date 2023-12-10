package com.example.teamfresh.service.compensation;

import com.example.teamfresh.dto.compensation.CompensationReqDto;
import com.example.teamfresh.dto.compensation.CompensationResDto;
import com.example.teamfresh.model.Compensation;
import com.example.teamfresh.model.Penalty;
import com.example.teamfresh.model.Voc;
import com.example.teamfresh.repository.CompensationRepository;
import com.example.teamfresh.repository.VocRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompensationService implements CompensationServiceI{

    private final CompensationRepository compensationRepository;
    private final VocRepository vocRepository;

    @Override
    public CompensationResDto getCompensation(String id) {
        return null;
    }

    @Override
    public Compensation createCompensation(int vocId, int damageAmount, Penalty penalty) {
        CompensationReqDto compensationReqDto = new CompensationReqDto();
        Voc voc = vocRepository.findById(vocId).orElseThrow(()-> new IllegalArgumentException("해당하는 VOC가 없습니다."));
        compensationReqDto.setAmount(damageAmount);
        compensationReqDto.setCustomer(voc.getCustomer());
        compensationReqDto.setVocId(voc);

        return compensationRepository.save(compensationReqDto.toEntity());
    }


}
