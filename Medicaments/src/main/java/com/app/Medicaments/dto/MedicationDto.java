package com.app.Medicaments.dto;

import lombok.Data;

@Data
public class MedicationDto {

    private Long ID;
    private String Nom;
    private String Marque;
    //UPET = unit price excluding taxes
    private Double UPET;
    private int QteStock;

}
