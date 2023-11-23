package com.example.relationspr4.controllers;

import com.example.relationspr4.models.CarModel;
import com.example.relationspr4.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController extends CrudController<CarModel, Long> {
    private final CarRepository carRepository;

    @Autowired
    public CarController(CarRepository carRepository) {
        super(carRepository, "car");
        this.carRepository = carRepository;
    }

    @GetMapping("/search")
    public String searchByMake(@RequestParam("make") String make, Model model) {
        List<CarModel> carByMake = carRepository.findByMake(make);
        model.addAttribute("cars", carByMake);
        return "cars/search_results";
    }
}