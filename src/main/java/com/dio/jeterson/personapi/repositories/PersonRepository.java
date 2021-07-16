package com.dio.jeterson.personapi.repositories;

import com.dio.jeterson.personapi.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>{
    
}
