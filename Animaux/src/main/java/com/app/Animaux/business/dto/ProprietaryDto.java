package com.app.Animaux.business.dto;

import lombok.Data;

@Data
public class ProprietaryDto {

    private Long Id;
    private String FirstName;
    private String LastName;
    private String CIN;

    private AnimalDto animalDto;

}
