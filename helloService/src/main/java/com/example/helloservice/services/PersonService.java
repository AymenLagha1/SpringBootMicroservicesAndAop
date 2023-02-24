package com.example.helloservice.services;

import com.example.helloservice.entities.Person;
import com.example.helloservice.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    public List<Person> getAll(){
        return personRepository.findAll();
    }
    public Person save(Person person){
        return personRepository.save(person);
    }
}
