package com.everis.d4i.tutorial.persistence;

import com.everis.d4i.tutorial.persistence.entities.Film;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    Slice<Film> findAllByCategory_Id(Integer category, Pageable pageable);

}
