package com.example.relationspr4.repositories;

import com.example.relationspr4.models.BookDetailModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDetailRepository extends JpaRepository<BookDetailModel, Long> {
    List<BookDetailModel> findAll();
}
