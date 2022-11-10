package com.app.Animaux.business.entity;

import com.app.Animaux.business.enums.Description_condition;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Animal")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Animal {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "Nom")
    private String Nom;

    @Column(name = "Date_Birth")
    private Date Date_Birth;

    @Column(name = "Race")
    private String Race;

    @Enumerated(EnumType.STRING)
    @Column(name = "Description_condition")
    private Description_condition description_condition;

    @ManyToOne
    @JoinColumn(name="Proprietary_ID", nullable=false)
    private Proprietary proprietary;

}
