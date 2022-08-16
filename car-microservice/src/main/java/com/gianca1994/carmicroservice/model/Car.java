package com.gianca1994.carmicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "car")
@Getter
@Setter
@NoArgsConstructor
public class Car {
    @Id
    private String id;
    private String brand;
    private String model;
    private String year;
    private String color;
    private Double price;
    private int amount;

    public Car(String brand, String model, String year, String color, Double price, int amount) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.amount = amount;
    }
}
