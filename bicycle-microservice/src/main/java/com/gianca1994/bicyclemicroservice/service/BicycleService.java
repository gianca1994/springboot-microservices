package com.gianca1994.bicyclemicroservice.service;

import com.gianca1994.bicyclemicroservice.dto.BicycleDTO;
import com.gianca1994.bicyclemicroservice.model.Bicycle;
import com.gianca1994.bicyclemicroservice.repository.BicycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BicycleService {

    @Autowired
    private BicycleRepository bicycleRepository;

    public List<Bicycle> getAll() {
        return bicycleRepository.findAll();
    }

    public Bicycle getById(String id) {
        return bicycleRepository.findById(id).orElse(null);
    }

    public void save(BicycleDTO bicycle) {
        Bicycle bicycleSearch = bicycleRepository.findByBrandAndModelAndFrameSizeAndTypeAndYearAndColorAndPrice(
                bicycle.getBrand(), bicycle.getModel(), bicycle.getFrameSize(), bicycle.getType(), bicycle.getYear(), bicycle.getColor(), bicycle.getPrice());

        if (bicycleSearch != null) {
            bicycleSearch.setAmount(bicycleSearch.getAmount() + 1);
            bicycleRepository.save(bicycleSearch);
            return;
        }

        bicycleRepository.save(new Bicycle(
                bicycle.getBrand(),
                bicycle.getModel(),
                bicycle.getFrameSize(),
                bicycle.getType(),
                bicycle.getYear(),
                bicycle.getColor(),
                bicycle.getPrice(),
                1
        ));
    }

    public void update(String id, Bicycle bicycle) {
        Bicycle bicycleSearch = bicycleRepository.findById(id).orElse(null);
        if (bicycleSearch == null) return;

        bicycleSearch.setBrand(bicycle.getBrand());
        bicycleSearch.setModel(bicycle.getModel());
        bicycleSearch.setFrameSize(bicycle.getFrameSize());
        bicycleSearch.setType(bicycle.getType());
        bicycleSearch.setYear(bicycle.getYear());
        bicycleSearch.setColor(bicycle.getColor());
        bicycleSearch.setPrice(bicycle.getPrice());

        bicycleRepository.save(bicycle);
    }

    public void delete(String id) {
        Bicycle bicycleSearch = bicycleRepository.findById(id).orElse(null);
        if (bicycleSearch == null) return;
        bicycleRepository.deleteById(id);
    }
}
