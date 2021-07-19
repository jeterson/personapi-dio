package com.dio.jeterson.personapi.controller;



import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.dio.jeterson.personapi.dto.PersonDTO;
import com.dio.jeterson.personapi.entity.Person;
import com.dio.jeterson.personapi.services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public PersonDTO create(@RequestBody @Valid PersonDTO personDTO) {        
       Person person = personService.save(personDTO.convertToPerson());
       return new PersonDTO(person);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<PersonDTO> findAll() {
        return personService.findAll().stream().map(PersonDTO::toDTO).collect(Collectors.toList());
    }
}
