package com.app.Animaux.business.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Proprietary")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")

public class Proprietary {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "FirstNom")
    private String FirstNom;

    @Column(name = "LastNom")
    private String LastNom;

    @Column(name = "CIN")
    private String CIN;

    @OneToMany(mappedBy = "proprietary")
    private List<Animal> Proprietary;

}
