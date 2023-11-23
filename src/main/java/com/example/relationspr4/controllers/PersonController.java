package com.example.relationspr4.controllers;

import com.example.relationspr4.models.PersonModel;
import com.example.relationspr4.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/persons")
public class PersonController  extends CrudController<PersonModel, Long> {
    private final PersonRepository personRepository;


    @Autowired
    public PersonController(PersonRepository personRepository) {
        super(personRepository, "person");
        this.personRepository = personRepository;
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam("name") String name, Model model) {
        List<PersonModel> personByName = personRepository.findByName(name);
        model.addAttribute("persons", personByName);
        return "persons/search_results";
    }
}