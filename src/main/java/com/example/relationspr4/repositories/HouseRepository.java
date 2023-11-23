package com.example.relationspr4.repositories;

import com.example.relationspr4.models.HouseModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseRepository extends JpaRepository<HouseModel, Long> {
    List<HouseModel> findByAddress(String address);
    
}
