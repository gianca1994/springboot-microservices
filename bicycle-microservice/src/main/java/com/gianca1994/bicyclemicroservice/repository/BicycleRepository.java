package com.gianca1994.bicyclemicroservice.repository;

import com.gianca1994.bicyclemicroservice.model.Bicycle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BicycleRepository extends MongoRepository<Bicycle, String> {
}
