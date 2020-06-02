package com.everis.d4i.tutorial.services.impl;

import com.everis.d4i.tutorial.json.FilmRest;
import com.everis.d4i.tutorial.json.FilteringParameters;
import com.everis.d4i.tutorial.persistence.FilmRepository;
import com.everis.d4i.tutorial.persistence.entities.Film;
import com.everis.d4i.tutorial.persistence.specifications.ReusableFilmSpecifications;
import com.everis.d4i.tutorial.services.FilmService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository filmRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<FilmRest> getFilmsFilteredByMinimumDuration(final Integer duration) {
        return filmRepository.findAllByDurationGreaterThan(duration).stream()
                       .map(film -> modelMapper.map(film, FilmRest.class))
                       .collect(Collectors.toList());
    }

    @Override
    public List<FilmRest> getDynamicallyFiltered(final FilteringParameters filteringParameters) {

        /*possible filtering options*/

//        final List<Film> filmList = filmRepository.findAll(ReusableFilmSpecifications.hasName(filteringParameters.getName()));

//        final List<Film> filmList = filmRepository.findAll(ReusableFilmSpecifications
//                                                                   .isYearEqual(Year.of(filteringParameters.getYear())));

        final List<Film> filmList = filmRepository.findAll(complexFilter(filteringParameters));

//        final List<Film> filmList = filmRepository.findAll(broadFilterBySubcategories(filteringParameters));

//        final List<Film> filmList = filmRepository.findAll(narrowFilterBySubcategories(filteringParameters));

//        final List<Film> filmList = filmRepository.findAll(staticFilteringOrderExample1());

//        final List<Film> filmList = filmRepository.findAll(staticFilteringOrderExample2());

        /*--------------------------*/

        return filmList.stream()
                       .map(film -> modelMapper.map(film, FilmRest.class))
                       .collect(Collectors.toList());
    }

    private Specification<Film> complexFilter(final FilteringParameters filters) {
        return Specification.where(ReusableFilmSpecifications.hasName(filters.getName())
                                           .and(ReusableFilmSpecifications.isYearEqual(Year.of(filters.getYear()))));
    }

    private Specification<Film> broadFilterBySubcategories(final FilteringParameters filters) {
        //(sucategory1 or subcategory 2 or ...)
        Specification<Film> condition1 = Specification.where(null);
        if ((filters.getSubcategories() != null) && (!filters.getSubcategories().isEmpty())) {
            for (String subcategory : filters.getSubcategories()) {
                condition1 = condition1.or(ReusableFilmSpecifications.hasShortDescription(subcategory));
            }
        }
        return Specification.where(condition1);
    }

    private Specification<Film> narrowFilterBySubcategories(final FilteringParameters filters) {
        //(sucategory1 and subcategory 2 and ...)
        Specification<Film> condition1 = Specification.where(null);
        if ((filters.getSubcategories() != null) && (!filters.getSubcategories().isEmpty())) {
            for (String subcategory : filters.getSubcategories()) {
                condition1 = condition1.and(ReusableFilmSpecifications.hasShortDescription(subcategory));
            }
        }
        return Specification.where(condition1);
    }

    private Specification<Film> staticFilteringOrderExample1() {
        /*category = 9 && subcategory = drama || subcategory = comedy
         * returns all biographical dramas or comedies*/
        return Specification.where(ReusableFilmSpecifications.isCategoryEqual(9))
                       .and(ReusableFilmSpecifications.hasShortDescription("drama"))
                       .or(ReusableFilmSpecifications.hasShortDescription("comedy"));
    }

    private Specification<Film> staticFilteringOrderExample2() {
        /*category = 9 && (subcategory = drama || subcategory = comedy)
         * returns all biographical dramas OR biographical comedies*/
        return Specification.where(ReusableFilmSpecifications.isCategoryEqual(9))
                       .and(ReusableFilmSpecifications.hasShortDescription("drama")
                                    .or(ReusableFilmSpecifications.hasShortDescription("comedy")));
    }
}
