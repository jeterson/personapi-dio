package com.dio.jeterson.personapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com/dio/jeterson/personapi/build/classes/java/main/com/dio/jeterson/personapi/mapper")
public class PersonapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonapiApplication.class, args);
	}

}
