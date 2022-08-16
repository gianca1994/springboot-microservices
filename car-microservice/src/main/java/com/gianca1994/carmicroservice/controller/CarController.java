package com.gianca1994.carmicroservice.controller;

import com.gianca1994.carmicroservice.dto.CarDTO;
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

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable String id) {
        return carService.getCarById(id);
    }

    @PostMapping
    public void saveCar(@RequestBody CarDTO car) {
        carService.saveCar(car);
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable String id, @RequestBody CarDTO car) {
        return carService.updateCar(id, car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable String id) {
        carService.deleteCar(id);
    }
}
