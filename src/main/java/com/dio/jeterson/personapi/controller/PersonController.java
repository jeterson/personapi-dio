package com.dio.jeterson.personapi.controller;



import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.dio.jeterson.personapi.dto.PersonDTO;
import com.dio.jeterson.personapi.entity.Person;
import com.dio.jeterson.personapi.exceptions.EntityNotFoundException;
import com.dio.jeterson.personapi.services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/people/v1")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {
    
    
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

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public PersonDTO findById(@PathVariable Long id) throws EntityNotFoundException{
        return PersonDTO.toDTO(personService.findById(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public PersonDTO update(@PathVariable Long id, @RequestBody @Valid PersonDTO dto) throws EntityNotFoundException{
        return PersonDTO.toDTO(personService.updateById(id,dto.convertToPerson()));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        personService.delete(id);
    }


}
