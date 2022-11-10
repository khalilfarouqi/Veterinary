package com.app.Membres.entity;

import com.app.Membres.enums.Post;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Members")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Members {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "FirstName")
    private String FirstName;

    @Column(name = "LastName")
    private String LastName;

    @Column(name = "BirthDay")
    private Date BirthDay;

    @Enumerated(EnumType.STRING)
    @Column(name = "Post")
    private Post post;

    @Column(name = "HiringDate")
    private Date Hiring_Date;

}
