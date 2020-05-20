package com.everis.d4i.tutorial.services.impl;

import com.everis.d4i.tutorial.json.FilmRest;
import com.everis.d4i.tutorial.persistence.FilmRepository;
import com.everis.d4i.tutorial.persistence.entities.Film;
import com.everis.d4i.tutorial.persistence.specifications.ReusableFilmSpecifications;
import com.everis.d4i.tutorial.services.FilmService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<FilmRest> getDynamicallyFiltered(
            final String name,
            final Integer year,
            final String country,
            final List<String> languages,
            final Integer category,
            final List<String> subcategories,
            final Integer minimumDuration) {

        final List<Film> filmList = filmRepository.findAll(ReusableFilmSpecifications
                                                                   .hasShortDescription("drama"));

        return filmList.stream()
                       .map(film -> modelMapper.map(film, FilmRest.class))
                       .collect(Collectors.toList());
    }

}
