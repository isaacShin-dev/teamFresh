package com.example.teamfresh.service.voc;

import com.example.teamfresh.dto.voc.VocReqDto;
import com.example.teamfresh.dto.voc.VocResDto;
import com.example.teamfresh.enums.ProcessEnum;

import java.util.List;

public interface VocServiceI {
    VocResDto createVoc(VocReqDto complaint, int customerId, int driverId);
    VocResDto setVocFault(int vocId, int faultCode, Boolean isDriverFault);
    VocResDto DriverResponse(int vocId, int penaltyId, Boolean isAccepted);
    List<VocResDto> getVocListByProcess(String processStatus);
    List<VocResDto> getAllVocs();
}
