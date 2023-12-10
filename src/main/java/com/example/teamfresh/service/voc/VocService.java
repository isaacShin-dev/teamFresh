package com.example.teamfresh.service.voc;

import com.example.teamfresh.appPush.MessageBody;
import com.example.teamfresh.dto.penalty.PenaltyResDto;
import com.example.teamfresh.dto.voc.VocReqDto;
import com.example.teamfresh.dto.voc.VocResDto;
import com.example.teamfresh.enums.ProcessEnum;
import com.example.teamfresh.enums.VocEnum;
import com.example.teamfresh.appPush.service.ProducerService;
import com.example.teamfresh.model.*;
import com.example.teamfresh.repository.DriverRepository;
import com.example.teamfresh.repository.VocRepository;
import com.example.teamfresh.repository.CustomerRepository;
import com.example.teamfresh.service.compensation.CompensationService;
import com.example.teamfresh.service.customer.CustomerService;
import com.example.teamfresh.service.driver.DriverService;
import com.example.teamfresh.service.penalty.PenaltyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VocService implements VocServiceI {

    private final VocRepository vocRepository;
    private final DriverService driverService;
    private final CustomerService customerService;
    private final CompensationService compensationService;
    private final PenaltyService penaltyService;
    private final ProducerService producerService;


    @Override
    public VocResDto createVoc(VocReqDto complaint, int customerId, int driverId) {
        Customer customer = customerService.getCustomerById(customerId).toEntity();
        Driver driver = driverService.getDriverInfo(driverId).toEntity();


        complaint.setCustomer_id(customer);
        complaint.setDriver_id(driver);

        complaint.setDefaultValues();

        Voc voc = complaint.toEntity();
        Voc savedVoc = vocRepository.save(voc);
        return new VocResDto(savedVoc);
    }

    /**
     * @Description : 발행된 VOC 를 담당자가 확인하여 귀책 사유를 등록하는 API
     */
    @Override
    public VocResDto setVocFault(int vocId, int faultCode, Boolean isDriverFault) {
        Voc voc = vocRepository.findById(vocId).orElseThrow(() -> new IllegalArgumentException("해당 VOC가 없습니다."));

        Compensation comp = null;
        switch (faultCode){
            case 1:
                comp = compensationService.createCompensation(vocId, voc.getDamageAmount(), null);
                voc.setFault(VocEnum.VOC_TYPE_1);  // 고객사
                voc.setProcessStatus(ProcessEnum.PROCESS_TYPE_5);  // 운성 업체의 잘못임으로, 바로 보상 처리 완료
                voc.setCompensation(comp);  // 배상 정보 등록
                break;
            case 2:
                voc.setFault(VocEnum.VOC_TYPE_2);  // 운송사
                if(isDriverFault){
                    voc.setIsDriverFault(true);
                    voc.setProcessStatus(ProcessEnum.PROCESS_TYPE_2);  // App push to driver
                    penaltyService.createPenalty(voc);//패널티 등록
                    producerService.sendMessage("topic", MessageBody.bodyConstruct(voc));  // App push to driver

                }else{
                    //운송사에 대한 귀책은 접수 후 바로 배상(Compensation) 정보를 등록
                    comp = compensationService.createCompensation(vocId, voc.getDamageAmount(), null);
                    voc.setProcessStatus(ProcessEnum.PROCESS_TYPE_5);  // 운성 업체의 잘못임으로, 바로 보상 처리 완료
                    voc.setCompensation(comp);  // 배상 정보 등록
                }
                break;
        }


        Voc savedVoc = vocRepository.save(voc);
        return new VocResDto(savedVoc);
    }

    @Override
    public VocResDto DriverResponse(int vocId, int penaltyId, Boolean isAccepted) {
        Voc voc = vocRepository.findById(vocId).orElseThrow(() -> new IllegalArgumentException("해당 VOC가 없습니다."));
        Penalty penalty = penaltyService.getPenaltyInfo(penaltyId).toEntity();

        if(isAccepted){
            voc.setProcessStatus(ProcessEnum.PROCESS_TYPE_3); // accept
            Compensation comp = compensationService.createCompensation(vocId, voc.getDamageAmount(), penalty);
            voc.setCompensation(comp);  // 배상 정보 등록
            penalty.setCompensation(comp);
            penaltyService.updatePenalty(penalty);
        }else{
            voc.setProcessStatus(ProcessEnum.PROCESS_TYPE_4); // reject
        }
        Voc savedVoc = vocRepository.save(voc);
        return new VocResDto(savedVoc);
    }

    @Override
    public List<VocResDto> getVocListByProcess(String processStatus) {
        List<Voc> vocList = vocRepository.findAllByprocessStatus(ProcessEnum.valueOf(processStatus));
        return vocList.stream().map(VocResDto::new).collect(Collectors.toList());
    }

    @Override
    public List<VocResDto> getAllVocs() {
        List<Voc> vocList = vocRepository.findAll();
        return vocList.stream().map(VocResDto::new).collect(Collectors.toList());
    }
}
