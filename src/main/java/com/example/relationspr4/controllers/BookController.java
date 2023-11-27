package com.example.relationspr4.controllers;

import com.example.relationspr4.models.BookDetailModel;
import com.example.relationspr4.models.BookModel;
import com.example.relationspr4.repositories.BookDetailRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.relationspr4.repositories.BookRepository;
import com.example.relationspr4.repositories.BookCategoryRepository;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;
    private final BookCategoryRepository categoryRepository;
    private final BookDetailRepository bookDetailRepository;

    public BookController(BookRepository bookRepository, BookCategoryRepository categoryRepository, BookDetailRepository bookDetailRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.bookDetailRepository = bookDetailRepository;
    }

    @GetMapping()
    public String getAll(Model model) {
        List<BookModel> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "books/index";
    }

    @GetMapping("/new")
    public String newBookForm(Model model) {
        model.addAttribute("book", new BookModel());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("bookDetails", bookDetailRepository.findAll());
        return "books/new";
    }

    @GetMapping("/{id}")
    public String showBook(@PathVariable Long id, Model model) {
        Optional<BookModel> book = bookRepository.findById(id);
        model.addAttribute("book", book.orElse(null));
        return "books/show";
    }

    @PostMapping
    public String createBook(@Valid @ModelAttribute("book") BookModel book,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/new";
        }

        BookDetailModel bookDetail = book.getBookDetail();
        bookDetail.setBook(book);
        bookRepository.save(book);
        return "redirect:/books";
    }


    @GetMapping("/{id}/edit")
    public String editBookForm(@PathVariable Long id, Model model) {
        Optional<BookModel> book = bookRepository.findById(id);
        model.addAttribute("book", book.orElse(null));
        model.addAttribute("categories", categoryRepository.findAll());
        return "books/edit";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable Long id, @Valid @ModelAttribute("book") BookModel book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/edit";
        }
        BookDetailModel bookDetail = book.getBookDetail();
        bookDetail.setBook(book);
        bookRepository.save(book);
        return "redirect:/books";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/books";
    }

    @GetMapping("/search")
    public String searchByAuthor(@RequestParam("author") String author, Model model) {
        List<BookModel> booksByAuthor = bookRepository.findByAuthor(author);
        model.addAttribute("books", booksByAuthor);
        return "books/search_results";
    }
}
