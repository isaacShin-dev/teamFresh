package com.example.teamfresh.service.deliverycompany;

import com.example.teamfresh.dto.deliveryComp.deliveryResDto;
import com.example.teamfresh.dto.deliveryComp.deliveryReqDto;

public interface DeliveryCmpServiceI {
    deliveryResDto getDeliveryCmpById(int id);
    deliveryResDto createDeliveryCmp(deliveryReqDto deliveryResDto);
    deliveryResDto updateDeliveryCmp(int id, deliveryResDto deliveryResDto);
    deliveryResDto updateDeliveryCmpActivation(int id);




}
