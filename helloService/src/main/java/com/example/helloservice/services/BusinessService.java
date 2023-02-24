package com.example.helloservice.services;

import org.springframework.stereotype.Service;


@Service
public class BusinessService {
    public String doSomething() {
        return "réalise un traitement important pour l'application" ;
    }
    public String doAnOtherThing() {
        return "réalise un autre traitement important pour l'application" ;
    }

}
