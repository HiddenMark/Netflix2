package com.everis.d4i.tutorial.persistence;

import com.everis.d4i.tutorial.persistence.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    List<Film> findAllByDurationGreaterThan(Integer duration);
}
