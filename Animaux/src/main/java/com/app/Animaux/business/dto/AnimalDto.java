package com.app.Animaux.business.dto;

import com.app.Animaux.business.enums.Description_condition;
import lombok.Data;

import java.util.Date;

@Data
public class AnimalDto {

    private Long Id;
    private String Nom;
    private Date Date_Birth;
    private String Race;
    private Description_condition description_condition;

    private ProprietaryDto proprietaryDto;

}
