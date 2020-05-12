package com.everis.d4i.tutorial.persistence.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "categories_films", uniqueConstraints={@UniqueConstraint(name = "unique_category_film", columnNames = {"category_id" , "film_id"})})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryFilms {

    private static final long serialVersionUID = -5461593488647785155L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;

}
