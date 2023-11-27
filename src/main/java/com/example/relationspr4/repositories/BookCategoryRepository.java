package com.example.relationspr4.repositories;

import com.example.relationspr4.models.BookCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookCategoryRepository extends JpaRepository<BookCategoryModel, Long> {
    List<BookCategoryModel> findAll();
}
