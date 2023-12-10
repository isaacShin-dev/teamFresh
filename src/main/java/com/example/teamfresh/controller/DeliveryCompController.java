package com.example.teamfresh.controller;

import com.example.teamfresh.dto.deliveryComp.deliveryReqDto;
import com.example.teamfresh.global.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.teamfresh.service.deliverycompany.DeliveryCompService;

@RestController
@RequestMapping("/api/v1/deliveryComp")
@RequiredArgsConstructor
public class DeliveryCompController {

    private final DeliveryCompService deliveryCompService;

    @GetMapping("/{id}/")
    public CustomResponse<?> getDeliveryCompById(@PathVariable int id) {
        return new CustomResponse<>(CustomResponse.StatusCode.SUCCESS, deliveryCompService.getDeliveryCmpById(id));
    }

    @PostMapping("/")
    public CustomResponse<?> createDeliveryComp(@RequestBody deliveryReqDto deliveryReqDto) {
        return new CustomResponse<>(CustomResponse.StatusCode.SUCCESS, deliveryCompService.createDeliveryCmp(deliveryReqDto));
    }

}
