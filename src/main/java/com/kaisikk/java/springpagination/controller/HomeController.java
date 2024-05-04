package com.kaisikk.java.springpagination.controller;

import com.kaisikk.java.springpagination.domain.Person;
import com.kaisikk.java.springpagination.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.stream.IntStream;

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

    @GetMapping("/pagination")
    public String listPersons(
            Model model,
//            @RequestParam(value = "size", required = false, defaultValue = "0") Integer size,
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page) {

        Page<Person> personPage = personRepo.findAll(PageRequest.of(page, 7));

        model.addAttribute("personsPage", personPage);
        model.addAttribute("numbers", IntStream.range(0, personPage.getTotalPages()).toArray());

        return "indexpag";
    }

}
