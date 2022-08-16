package com.gianca1994.bicyclemicroservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BicycleDTO {
    private String brand;
    private String model;
    private int frameSize;
    private String type;
    private String year;
    private String color;
    private Double price;
}
