package com.example.helloservice.controllers;

import com.example.helloservice.entities.Person;
import com.example.helloservice.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/person")
@RestController
public class PersonController {


    final PersonService personService;
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    public List<Person> getAll(){
        return personService.getAll();
    }

    @PostMapping("/create")
    public Person create(@RequestBody Person person){
        return personService.save(person);
    }
}
