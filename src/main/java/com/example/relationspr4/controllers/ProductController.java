package com.example.relationspr4.controllers;

import com.example.relationspr4.models.ProductModel;
import com.example.relationspr4.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController extends CrudController<ProductModel, Long> {
    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        super(productRepository, "product");
        this.productRepository = productRepository;
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam("name") String name, Model model) {
        List<ProductModel> productByName = productRepository.findByName(name);
        model.addAttribute("products", productByName);
        return "products/search_results";
    }
}
