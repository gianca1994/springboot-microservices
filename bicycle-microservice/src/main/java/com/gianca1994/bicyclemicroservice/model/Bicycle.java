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
}
