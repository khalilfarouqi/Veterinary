package com.app.Medicaments.dto;

import lombok.Data;

@Data
public class MedicationDto {

    private Long id;
    private String name;
    private String marque;
    //UPET = unit price excluding taxes
    private Double upet;
    private int qteStock;

}
