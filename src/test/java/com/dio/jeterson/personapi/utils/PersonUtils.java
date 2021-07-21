package com.dio.jeterson.personapi.utils;

import java.time.LocalDate;
import java.util.Collections;

import com.dio.jeterson.personapi.dto.PersonDTO;
import com.dio.jeterson.personapi.entity.Person;

public class PersonUtils {
    

    public static PersonDTO createFakeDTO() {
        return PersonDTO.toDTO(createFakeEntity());
    }

    public static Person createFakeEntity() {
        return Person.builder()
        .birthDate(LocalDate.of(1992, 8, 23))
        .cpf("11111111111")
        .firstName("Jeterson")
        .lastName("Miranda Gomes")
        .id(1L)
        .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
        .build();
    }

    
}
