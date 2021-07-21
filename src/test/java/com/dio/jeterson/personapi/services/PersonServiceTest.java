package com.dio.jeterson.personapi.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.dio.jeterson.personapi.dto.PersonDTO;
import com.dio.jeterson.personapi.entity.Person;
import com.dio.jeterson.personapi.repositories.PersonRepository;
import com.dio.jeterson.personapi.utils.PersonUtils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository repository;

    @InjectMocks
    private PersonService service;

    @Test
    void testCreatePersonSuccess() {
        PersonDTO personDTO = PersonUtils.createFakeDTO();
        Person expectPerson = personDTO.convertToPerson();

        when(repository.save(any(Person.class))).thenReturn(expectPerson);
        Person savedPerson = service.save(personDTO.convertToPerson());

        assertEquals(savedPerson.getId(), expectPerson.getId());
    }
    
}
