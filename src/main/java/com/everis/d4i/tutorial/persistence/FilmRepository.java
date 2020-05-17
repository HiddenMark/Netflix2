package com.everis.d4i.tutorial.persistence;

import com.everis.d4i.tutorial.persistence.entities.Film;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    List<Film> findAllByOrderByYearDesc();

    List<Film> findAllByCategory_Id(Integer category, Sort sort);

}
