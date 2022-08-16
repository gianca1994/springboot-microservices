package com.gianca1994.bicyclemicroservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "bicycles")
@Getter
@Setter
@NoArgsConstructor
public class Bicycle {
    @Id
    private String id;
    private String brand;
    private String model;
    private int frameSize;
    private String type;
    private String year;
    private String color;
    private Double price;
    private int amount;

    public Bicycle(String brand, String model, int frameSize, String type, String year, String color, Double price, int amount) {
        this.brand = brand;
        this.model = model;
        this.frameSize = frameSize;
        this.type = type;
        this.year = year;
        this.color = color;
        this.price = price;
        this.amount = amount;
    }
}
