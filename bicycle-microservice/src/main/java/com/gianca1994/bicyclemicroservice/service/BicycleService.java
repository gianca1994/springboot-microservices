package com.gianca1994.bicyclemicroservice.service;

import com.gianca1994.bicyclemicroservice.dto.BicycleDTO;
import com.gianca1994.bicyclemicroservice.model.Bicycle;
import com.gianca1994.bicyclemicroservice.repository.BicycleRepository;
import com.gianca1994.bicyclemicroservice.exception.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BicycleService {

    @Autowired
    private BicycleRepository bicycleRepository;

    public List<Bicycle> getAll() {
        return bicycleRepository.findAll();
    }

    public Bicycle getById(String id) {
        return bicycleRepository.findById(id).orElseThrow(() -> new NotFound("Bicycle not found"));
    }

    public void save(BicycleDTO bicycle) {
        checkBicycle(bicycle);

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

    public void update(String id, BicycleDTO bicycle) {
        if (Objects.isNull(id)) throw new NotFound("Id cannot be null");
        checkBicycle(bicycle);

        Bicycle bicycleSearch = bicycleRepository.findById(id).orElse(null);
        if (bicycleSearch == null) throw new NotFound("Bicycle not found");

        bicycleSearch.setBrand(bicycle.getBrand());
        bicycleSearch.setModel(bicycle.getModel());
        bicycleSearch.setFrameSize(bicycle.getFrameSize());
        bicycleSearch.setType(bicycle.getType());
        bicycleSearch.setYear(bicycle.getYear());
        bicycleSearch.setColor(bicycle.getColor());
        bicycleSearch.setPrice(bicycle.getPrice());

        bicycleRepository.save(bicycleSearch);
    }

    public void delete(String id) {
        if (Objects.isNull(id)) throw new NotFound("Id cannot be null");

        Bicycle bicycleSearch = bicycleRepository.findById(id).orElse(null);
        if (bicycleSearch == null) throw new NotFound("Bicycle not found");

        bicycleRepository.deleteById(id);
    }

    private void checkBicycle(BicycleDTO bicycle) {
        if (Objects.isNull(bicycle.getBrand())) throw new NotFound("Brand cannot be null");
        if (Objects.isNull(bicycle.getModel())) throw new NotFound("Model cannot be null");
        if (bicycle.getFrameSize() < 0) throw new NotFound("Frame size cannot be negative");
        if (Objects.isNull(bicycle.getType())) throw new NotFound("Type cannot be null");
        if (Objects.isNull(bicycle.getYear())) throw new NotFound("Year cannot be null");
        if (Objects.isNull(bicycle.getColor())) throw new NotFound("Color cannot be null");
        if (Objects.isNull(bicycle.getPrice())) throw new NotFound("Price cannot be null");
        if (bicycle.getPrice() < 0) throw new NotFound("Price cannot be negative");
    }
}
