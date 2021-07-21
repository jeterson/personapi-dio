package com.dio.jeterson.personapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code =  HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException{
    
    public EntityNotFoundException(Class<?> classz, Object id) {
        super("Entity " + classz.getSimpleName() + " not found. Params {" + id + "}");
    }

    public EntityNotFoundException() {}
}
