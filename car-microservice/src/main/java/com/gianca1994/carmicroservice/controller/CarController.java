package com.gianca1994.carmicroservice.controller;

import com.gianca1994.carmicroservice.model.Car;
import com.gianca1994.carmicroservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping
    public void saveCar(@RequestBody Car car) {
        carService.saveCar(car);
    }
}
