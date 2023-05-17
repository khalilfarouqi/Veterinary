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
    private Long id;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "BirthDay")
    private Date birthDay;

    @Enumerated(EnumType.STRING)
    @Column(name = "Post")
    private Post post;

    @Column(name = "HiringDate")
    private Date hiringDate;

}
