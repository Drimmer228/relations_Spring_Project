package com.example.relationspr4.repositories;

import com.example.relationspr4.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookModel, Long> {
    List<BookModel> findByAuthor(String author);
}
