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

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Marque")
    private String Marque;

    @Column(name = "UPET")
    //UPET = unit price excluding taxes
    private Double UPET;

    @Column(name = "QteStock")
    private int QteStock;

}
