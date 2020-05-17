package com.everis.d4i.tutorial.persistence.entities;

import lombok.*;

import javax.persistence.*;
import java.time.Year;
import java.util.List;

@Entity
@Table(name = "films")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Film {

    private static final long serialVersionUID = 5265882376461617162L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "year", nullable = false)
    private Year year;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "language", nullable = false)
    private String language;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "short_desc")
    private String shortDescription;

    @Column(name = "long_desc")
    private String longDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "film")
    private List<Cast> castList;
}
