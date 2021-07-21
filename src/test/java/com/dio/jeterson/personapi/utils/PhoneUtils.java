package com.dio.jeterson.personapi.utils;

import com.dio.jeterson.personapi.dto.PhoneDTO;
import com.dio.jeterson.personapi.entity.Phone;
import com.dio.jeterson.personapi.enums.PhoneType;

public class PhoneUtils {
    
    public static Phone createFakeEntity() {
        return Phone.builder()
        .number("12345679123")
        .type(PhoneType.MOBILE)
        .id(1L)
        .build();
    }

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
        .id(createFakeEntity().getId())
        .number(createFakeEntity().getNumber())
        .type(createFakeEntity().getType())
        .build();
    }
}
