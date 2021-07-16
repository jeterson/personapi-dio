package com.dio.jeterson.personapi.services;

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
}
