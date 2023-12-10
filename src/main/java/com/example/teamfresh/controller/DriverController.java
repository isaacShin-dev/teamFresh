package com.example.teamfresh.controller;

import com.example.teamfresh.dto.driver.DriverReqDto;
import com.example.teamfresh.dto.driver.DriverResDto;
import com.example.teamfresh.global.CustomResponse;
import com.example.teamfresh.service.driver.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/driver")
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @GetMapping("/{driverId}")
    public CustomResponse<?> getDriverInfo(@PathVariable int driverId) {
        return new CustomResponse<>(CustomResponse.StatusCode.SUCCESS, driverService.getDriverInfo(driverId));
    }

    @PostMapping("/{companyId}/")
    public CustomResponse<?> createDriver(@RequestBody DriverReqDto driverReqDto, @PathVariable int companyId) {
        return new CustomResponse<>(CustomResponse.StatusCode.SUCCESS, driverService.createDriver(driverReqDto, companyId));
    }



}
