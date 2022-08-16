package com.gianca1994.carmicroservice.service;

import com.gianca1994.carmicroservice.dto.CarDTO;
import com.gianca1994.carmicroservice.repository.CarRepository;
import com.gianca1994.carmicroservice.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(String id) {
        return carRepository.findById(id).orElse(null);
    }

    public void saveCar(CarDTO car) {
        Car carSearch = carRepository.findByBrandAndModelAndYearAndColor(
                car.getBrand(), car.getModel(), car.getYear(), car.getColor());

        if (carSearch != null) {
            carSearch.setAmount(carSearch.getAmount() + 1);
            carRepository.save(carSearch);
        }

        carRepository.save(new Car(
                car.getBrand(),
                car.getModel(),
                car.getYear(),
                car.getColor(),
                car.getPrice(),
                1
        ));
    }

    public Car updateCar(String id, CarDTO car) {
        Car carUpdate = carRepository.findById(id).orElse(null);

        if (carUpdate == null) return null;

        carUpdate.setBrand(car.getBrand());
        carUpdate.setModel(car.getModel());
        carUpdate.setYear(car.getYear());
        carUpdate.setColor(car.getColor());
        carUpdate.setPrice(car.getPrice());
        return carRepository.save(carUpdate);
    }

    public void deleteCar(String id) {
        carRepository.deleteById(id);
    }
}
