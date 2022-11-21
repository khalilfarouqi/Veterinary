package com.app.Animaux.business.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProprietaryDto {

    private Long Id;
    private String FirstNom;
    private String LastNom;
    private String CIN;

    private List<AnimalDto> animal;

}
