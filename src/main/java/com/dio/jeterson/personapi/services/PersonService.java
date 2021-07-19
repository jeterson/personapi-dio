package com.dio.jeterson.personapi.services;

import java.time.LocalDate;
import java.util.List;

import com.dio.jeterson.personapi.dto.PersonDTO;
import com.dio.jeterson.personapi.entity.Person;
import com.dio.jeterson.personapi.repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepository personRepository;

    
    public Person save(Person person) {        
        return personRepository.save(person);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }


}
