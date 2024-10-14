package com.auca.logistics.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auca.logistics.Model.Driver;
import com.auca.logistics.Model.DriverRepository;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public Driver findById(int  id) {
        return driverRepository.findById(id).orElse(null); 
    }

    public void updateDriver(Driver driver) {
        driverRepository.save(driver); // Save the updated driver
    }
}

