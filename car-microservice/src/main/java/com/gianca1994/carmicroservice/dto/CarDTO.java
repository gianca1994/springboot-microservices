package com.gianca1994.carmicroservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarDTO {
    private String brand;
    private String model;
    private String year;
    private String color;
    private Double price;
}
