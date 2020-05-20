package com.everis.d4i.tutorial.persistence;

import com.everis.d4i.tutorial.persistence.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Year;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    List<Film> findAllByDurationGreaterThan(Integer duration);

    /*short description has been used in the database to store a descriptive string with categories,
     * so we can now use it to find a main category and subcategories*/
    List<Film> findAllByCategory_IdAndShortDescriptionContaining(Integer categoryId, String secondaryCategory);

    List<Film> findTop10ByLanguageInOrderByLanguageDesc(Collection<String> possibleLanguages);

    Optional<Film> findFirstByYearBeforeAndDurationIsNotNullAndCountry(Year year, String country);

    @Query(value = "select f from Film f where f.year = :year and f.category.name = :name")
    List<Film> myOwnJPQLQueryFunctionFilterByYearAndCategory(
            @Param("year") Year year,
            @Param("name") String categoryName);

    @Query(nativeQuery = true,
            value = "select * " +
                            "from films " +
                            "where year = :year " +
                            "    and category_id = (select id from categories where name = :name);")
    List<Film> myOwnNativeQueryFunctionFilterByYearAndCategory(
            @Param("year") Integer year,
            @Param("name") String categoryName);

    @Query(value = "select f from Film f where f.language in :languages ")
    List<Film> myOwnQueryWithAListAsParam(
            @Param("languages") Collection<String> languageCollection);

}
