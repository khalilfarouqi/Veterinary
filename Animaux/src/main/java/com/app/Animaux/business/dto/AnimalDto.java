package com.app.Animaux.business.dto;

import com.app.Animaux.business.enums.Description_condition;
import lombok.Data;

import java.util.Date;

@Data
public class AnimalDto {

    private Long id;
    private String name;
    private Date dateBirth;
    private String race;
    private Description_condition descriptionCondition;

    private ProprietaryDto proprietaryDto;

}
