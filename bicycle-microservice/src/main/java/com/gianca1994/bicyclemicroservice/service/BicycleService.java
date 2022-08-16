package com.gianca1994.bicyclemicroservice.service;

import com.gianca1994.bicyclemicroservice.model.Bicycle;
import com.gianca1994.bicyclemicroservice.repository.BicycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BicycleService {

    @Autowired
    private BicycleRepository bicycleRepository;

    public List<Bicycle> getAllBicycles() {
        return bicycleRepository.findAll();
    }

    public void save(Bicycle bicycle) {
        bicycleRepository.save(bicycle);
    }
}
