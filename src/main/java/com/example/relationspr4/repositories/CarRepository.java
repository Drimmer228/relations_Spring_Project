package com.example.relationspr4.repositories;

import com.example.relationspr4.models.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<CarModel, Long> {
    List<CarModel> findByMake(String make);
    
}
