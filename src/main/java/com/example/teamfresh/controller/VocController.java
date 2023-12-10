package com.example.teamfresh.controller;

import com.example.teamfresh.dto.voc.VocReqDto;
import com.example.teamfresh.global.CustomResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import com.example.teamfresh.service.voc.VocService;

@Slf4j
@RestController
@RequestMapping("/api/v1/voc")
@RequiredArgsConstructor
public class VocController {

    private final VocService vocService;

    @GetMapping("/")
    public CustomResponse<?> getAllVocsByProcess(@RequestParam(required = false) String processKey) {
        if (processKey != null) {
            return new CustomResponse<>(CustomResponse.StatusCode.SUCCESS, vocService.getVocListByProcess(processKey));
        }
        return new CustomResponse<>(CustomResponse.StatusCode.SUCCESS, vocService.getAllVocs());
    }

    @PostMapping("/")
    public CustomResponse<?> createComplaint(@RequestBody VocReqDto complaint, @RequestParam int customerId, @RequestParam int driverId) {
        return new CustomResponse<>(CustomResponse.StatusCode.SUCCESS, vocService.createVoc(complaint, customerId, driverId));
    }

    @PatchMapping("/{vocId}/")
    public CustomResponse<?> setVocFault(@PathVariable int vocId, @RequestParam int faultCode, @RequestParam(required = false) Boolean isDriverFault) {
        return new CustomResponse<>(CustomResponse.StatusCode.SUCCESS, vocService.setVocFault(vocId, faultCode, isDriverFault));
    }

    @PatchMapping("/{vocId}/{penaltyId}/")
    public CustomResponse<?> setVocProcess(@PathVariable int vocId, @PathVariable int penaltyId, @RequestParam Boolean isAccepted) {
        return new CustomResponse<>(CustomResponse.StatusCode.SUCCESS, vocService.DriverResponse(vocId, penaltyId, isAccepted));
    }
}
