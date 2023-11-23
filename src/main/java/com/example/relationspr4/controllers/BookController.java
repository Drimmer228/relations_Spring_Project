package com.example.relationspr4.controllers;

import com.example.relationspr4.models.BookModel;
import com.example.relationspr4.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController extends CrudController<BookModel, Long> {
    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        super(bookRepository, "book");
        this.bookRepository = bookRepository;
    }

    @GetMapping("/search")
    public String searchByAuthor(@RequestParam("author") String author, Model model) {
        List<BookModel> booksByAuthor = bookRepository.findByAuthor(author);
        model.addAttribute("books", booksByAuthor);
        return "books/search_results";
    }
}