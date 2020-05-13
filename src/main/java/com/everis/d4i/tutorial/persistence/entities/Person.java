package com.everis.d4i.tutorial.persistence.entities;

import lombok.*;

import javax.persistence.*;
import java.time.Year;
import java.util.List;

@Entity
@Table(name = "persons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    private static final long serialVersionUID = -1219062799354100288L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "birthday_year")
    private Year year;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    private List<Cast> castList;
}
