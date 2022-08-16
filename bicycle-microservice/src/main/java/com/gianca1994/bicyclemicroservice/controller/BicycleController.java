package com.gianca1994.bicyclemicroservice.controller;

import com.gianca1994.bicyclemicroservice.model.Bicycle;
import com.gianca1994.bicyclemicroservice.service.BicycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bicycles")
public class BicycleController {

    @Autowired
    private BicycleService bicycleService;

    @GetMapping
    public List<Bicycle> getAllBicycles() {
        return bicycleService.getAllBicycles();
    }

    @PostMapping
    public void save(@RequestBody Bicycle bicycle) {
        bicycleService.save(bicycle);
    }
}
