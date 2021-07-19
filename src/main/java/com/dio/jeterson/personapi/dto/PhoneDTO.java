package com.dio.jeterson.personapi.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.dio.jeterson.personapi.enums.PhoneType;
import com.dio.jeterson.personapi.validators.ValidEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhoneDTO {
    
    private Long id;
    
    @NotEmpty
    @Size(min = 13, max = 14)    
    private String number;

    @ValidEnum(regexp = "HOME|MOBILE|COMMERCIAL", message = "PhoneType must be HOME|MOBILE|COMMERCIAL")
    private PhoneType type;
}
