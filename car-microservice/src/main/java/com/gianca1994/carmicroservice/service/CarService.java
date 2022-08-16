package com.gianca1994.carmicroservice.service;

import com.gianca1994.carmicroservice.dto.CarDTO;
import com.gianca1994.carmicroservice.exception.BadRequest;
import com.gianca1994.carmicroservice.exception.NotFound;
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
        return carRepository.findById(id).orElseThrow(() -> new NotFound("Car not found"));
    }

    public void saveCar(CarDTO car) {
        checkCarObject(car);

        Car carSearch = carRepository.findByBrandAndModelAndYearAndColor(
                car.getBrand(), car.getModel(), car.getYear(), car.getColor());

        if (carSearch != null) {
            carSearch.setAmount(carSearch.getAmount() + 1);
            carRepository.save(carSearch);
            return;
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
        if (Objects.isNull(id)) throw new NotFound("Id cannot be null");
        checkCarObject(car);

        Car carUpdate = carRepository.findById(id).orElse(null);

        if (carUpdate == null) throw new NotFound("Car not found");

        carUpdate.setBrand(car.getBrand());
        carUpdate.setModel(car.getModel());
        carUpdate.setYear(car.getYear());
        carUpdate.setColor(car.getColor());
        carUpdate.setPrice(car.getPrice());
        return carRepository.save(carUpdate);
    }

    public void deleteCar(String id) {
        if (Objects.isNull(id)) throw new NotFound("Id cannot be null");

        Car carDelete = carRepository.findById(id).orElse(null);
        if (carDelete == null) throw new NotFound("Car not found");

        carRepository.deleteById(id);
    }

    private void checkCarObject(CarDTO car) {
        if (car.getBrand().isEmpty()) throw new BadRequest("Brand cannot be empty");
        if (car.getModel().isEmpty()) throw new BadRequest("Model cannot be empty");
        if (car.getYear().isEmpty()) throw new BadRequest("Year cannot be empty");
        if (car.getColor().isEmpty()) throw new BadRequest("Color cannot be empty");
        if (car.getPrice().isNaN()) throw new BadRequest("Price cannot be empty");
        if (car.getPrice() < 0) throw new BadRequest("Price cannot be less than 0");
    }
}
