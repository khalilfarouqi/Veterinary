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

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Date_Birth")
    private Date dateBirth;

    @Column(name = "Race")
    private String race;

    @Enumerated(EnumType.STRING)
    @Column(name = "Description_condition")
    private Description_condition descriptionCondition;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="Proprietary_ID")
    private Proprietary proprietary;

}
