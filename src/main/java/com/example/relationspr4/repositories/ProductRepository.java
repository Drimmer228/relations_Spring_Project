package com.example.relationspr4.repositories;

import com.example.relationspr4.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
    List<ProductModel> findByName(String name);
    
}
