package com.gianca1994.bicyclemicroservice.controller;

import com.gianca1994.bicyclemicroservice.dto.BicycleDTO;
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
    public List<Bicycle> getAll() {
        return bicycleService.getAll();
    }

    @GetMapping("/{id}")
    public Bicycle getById(@PathVariable String id) {
        return bicycleService.getById(id);
    }

    @PostMapping
    public void save(@RequestBody BicycleDTO bicycle) {
        bicycleService.save(bicycle);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody Bicycle bicycle) {
        bicycleService.update(id, bicycle);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        bicycleService.delete(id);
    }

}
