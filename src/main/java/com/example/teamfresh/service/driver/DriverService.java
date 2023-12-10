package com.example.teamfresh.service.driver;

import com.example.teamfresh.dto.deliveryComp.deliveryResDto;
import com.example.teamfresh.dto.driver.DriverReqDto;
import com.example.teamfresh.dto.driver.DriverResDto;
import com.example.teamfresh.model.DeliveryCompany;
import com.example.teamfresh.model.Driver;
import com.example.teamfresh.repository.DeliveryCompanyRepository;
import com.example.teamfresh.repository.DriverRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverService implements DriverServiceI{

    private final DriverRepository driverRepository;

    private final DeliveryCompanyRepository deliveryCompanyRepository;


    @Override
    public DriverResDto getDriverInfo(int driverId) {
        Driver driver = driverRepository.findById(driverId).orElseThrow(() -> {
            return new IllegalArgumentException("해당 드라이버가 없습니다.");
        });
        return new DriverResDto(driver);
    }

    @Override
    public DriverResDto createDriver(DriverReqDto driverReqDto, int companyId) {
        DeliveryCompany company = deliveryCompanyRepository.findById(companyId).orElseThrow(() -> {
            return new IllegalArgumentException("해당 배송업체가 없습니다.");
        });
        driverReqDto.setDeliveryCompany(company);
        Driver savedDriver = driverRepository.save(driverReqDto.toEntity());
        return new DriverResDto(savedDriver);
    }
}
