package com.dio.jeterson.personapi.services;

import java.util.List;

import com.dio.jeterson.personapi.entity.Person;
import com.dio.jeterson.personapi.exceptions.EntityNotFoundException;
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

    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Person.class, id));
    }


    public Person updateById(Long id, Person person) {
        findById(id);
        person.setId(id);
        return save(person);

    }

    public void delete(Long id) {
        findById(id);
        personRepository.deleteById(id);
    }


}
