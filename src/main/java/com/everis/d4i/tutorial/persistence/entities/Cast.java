package com.everis.d4i.tutorial.persistence.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "casts", uniqueConstraints={@UniqueConstraint(name = "unique_person_role_film", columnNames = {"person_id", "role_id" , "film_id"})})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cast {

    private static final long serialVersionUID = -5461593488647785155L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;
}
