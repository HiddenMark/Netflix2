package com.everis.d4i.tutorial.services.impl;

import com.everis.d4i.tutorial.json.FilmRest;
import com.everis.d4i.tutorial.persistence.FilmRepository;
import com.everis.d4i.tutorial.services.FilmService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<FilmRest> getFilmsByCategoryAndSubcategory(final Integer categoryId, final String subcategory) {
        return filmRepository.findAllByCategory_IdAndShortDescriptionContaining(categoryId, subcategory).stream()
                       .map(film -> modelMapper.map(film, FilmRest.class))
                       .collect(Collectors.toList());
    }

    @Override
    public List<FilmRest> getFilmsByYearAndCategoryNameWithNativeQuery(final Integer year, final String categoryName) {
        return filmRepository.myOwnNativeQueryFunctionFilterByYearAndCategory(year, categoryName).stream()
                       .map(film -> modelMapper.map(film, FilmRest.class))
                       .collect(Collectors.toList());
    }

    @Override
    public List<FilmRest> getFilmsByYearAndCategoryNameWithJPQLQuery(final Integer year, final String categoryName) {
        return filmRepository.myOwnJPQLQueryFunctionFilterByYearAndCategory(Year.of(year), categoryName).stream()
                       .map(film -> modelMapper.map(film, FilmRest.class))
                       .collect(Collectors.toList());
    }
}
