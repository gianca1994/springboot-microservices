package com.gianca1994.carmicroservice.service;

import com.gianca1994.carmicroservice.Repository.CarRepository;
import com.gianca1994.carmicroservice.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public void saveCar(Car car) {
        carRepository.save(car);
    }
}
