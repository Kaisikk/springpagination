package com.kaisikk.java.springpagination.controller;

import com.kaisikk.java.springpagination.domain.Person;
import com.kaisikk.java.springpagination.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private final PersonRepo personRepo;

    @Autowired
    public HomeController(PersonRepo personRepo){
        this.personRepo = personRepo;
    }

    @GetMapping("/")
    public String index (Model model){
        model.addAttribute("persons", personRepo.findLast10());
        return "index";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Iterable<Person> load (@PathVariable("id") Long id){
        return personRepo.findAllByIdBetweenOrderByIdDesc(id - 10L, id);
    }

}
