package com.example.helloservice.controllers;

import com.example.helloservice.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {
    @Autowired
    BusinessService businessService;
    @GetMapping("/service")
    public String DoBusinessService(){
        return businessService.doSomething();
    }
    @GetMapping("/otherService")
    public String DoOtherBusinessService(){
        return businessService.doAnOtherThing();
    }

}
