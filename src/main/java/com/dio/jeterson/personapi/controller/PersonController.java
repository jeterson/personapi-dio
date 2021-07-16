package com.dio.jeterson.personapi.controller;



import com.dio.jeterson.personapi.entity.Person;

import com.dio.jeterson.personapi.services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/people/v1")
public class PersonController {
    
    @Autowired
    private PersonService personService;

    @PostMapping    
    @ResponseStatus(code = HttpStatus.CREATED)
    public Person create(@RequestBody Person person) {
       person = personService.save(person);
       return person;
    }
}
