package com.example.teamfresh.service.driver;

import com.example.teamfresh.dto.driver.DriverReqDto;
import com.example.teamfresh.dto.driver.DriverResDto;

public interface DriverServiceI {
    DriverResDto getDriverInfo(int driverId);
    DriverResDto createDriver(DriverReqDto driverResDto, int companyId);
}
