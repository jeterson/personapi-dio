package com.dio.jeterson.personapi.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.dio.jeterson.personapi.entity.Person;
import com.dio.jeterson.personapi.entity.Phone;
import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDTO {
    
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String lastName;

    @CPF
    @NotEmpty
    private String cpf;


    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    @NotEmpty
    @Valid
    private List<PhoneDTO> phones;

    public static  PersonDTO toDTO(Person person) {
        return new PersonDTO(person);
    }

    public PersonDTO(Person person) {
        this.birthDate = person.getBirthDate();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.cpf = person.getCpf();
        this.id = person.getId();
        this.phones = person.getPhones().stream().map(p -> {
            return PhoneDTO.builder().id(p.getId()).number(p.getNumber()).type(p.getType()).build();
        }).collect(Collectors.toList());
    }

    public Person convertToPerson() {

        List<Phone> phones = this.phones.stream().map(p -> {
            return Phone.builder().id(p.getId()).number(p.getNumber()).type(p.getType()).build();
        }).collect(Collectors.toList());

        return Person.builder()
        .birthDate(this.birthDate)
        .id(this.id)
        .cpf(this.cpf)
        .firstName(this.firstName)
        .lastName(this.lastName) 
        .phones(phones)       
        .build();
    }
}
