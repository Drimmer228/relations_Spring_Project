package com.example.relationspr4.repositories;

import com.example.relationspr4.models.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<PersonModel, Long> {
    List<PersonModel> findByName(String name);
    
}
