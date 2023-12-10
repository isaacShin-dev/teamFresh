package com.example.teamfresh.service.deliverycompany;
import com.example.teamfresh.dto.deliveryComp.deliveryReqDto;
import com.example.teamfresh.dto.deliveryComp.deliveryResDto;
import com.example.teamfresh.model.DeliveryCompany;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.teamfresh.repository.DeliveryCompanyRepository;

@Service
@AllArgsConstructor
public class DeliveryCompService implements  DeliveryCmpServiceI{

    private  DeliveryCompanyRepository deliveryCompRepository;

    @Override
    public deliveryResDto getDeliveryCmpById(int id) {
        DeliveryCompany deliveryCompany = deliveryCompRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 배송업체가 없습니다. id=" + id));
        if (deliveryCompany == null) {
            return null;
        }
        return new deliveryResDto(deliveryCompany);
    }

    @Override
    public deliveryResDto createDeliveryCmp(deliveryReqDto deliveryResDto) {
        DeliveryCompany deliveryCompany = deliveryResDto.toEntity();
        DeliveryCompany savedDeliveryCompany = deliveryCompRepository.save(deliveryCompany);
        return new deliveryResDto(savedDeliveryCompany);

    }

    @Override
    public deliveryResDto updateDeliveryCmp(int id, deliveryResDto deliveryResDto) {
        return null;
    }

    @Override
    public deliveryResDto updateDeliveryCmpActivation(int id) {
        return null;
    }
}
