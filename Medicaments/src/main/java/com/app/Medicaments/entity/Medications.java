package com.app.Medicaments.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="Medications")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Medications {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Marque")
    private String marque;

    @Column(name = "UPET")
    //UPET = unit price excluding taxes
    private Double upet;

    @Column(name = "QteStock")
    private int qteStock;

}
