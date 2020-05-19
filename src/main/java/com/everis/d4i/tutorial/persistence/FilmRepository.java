package com.everis.d4i.tutorial.persistence;

import com.everis.d4i.tutorial.persistence.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Year;
import java.util.Collection;
import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    List<Film> findAllByDurationGreaterThan(Integer duration);

    /*short description has been used in the database to store a descriptive string with categories,
     * so we can now use it to find a main category and subcategories*/
    List<Film> findAllByCategory_IdAndShortDescriptionContaining(Integer categoryId, String secondaryCategory);

    List<Film> findTop10ByLanguageInOrderByLanguageDesc(Collection<String> possibleLanguages);

    List<Film> findFirstByYearBeforeAndDurationExistsAndCountry(Year year, String country);

}
