package com.everis.d4i.tutorial.services.impl;

import com.everis.d4i.tutorial.json.FilmRest;
import com.everis.d4i.tutorial.persistence.FilmRepository;
import com.everis.d4i.tutorial.services.FilmService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository filmRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<FilmRest> getFilmsSortedDynamically(final Sort sort) {

        return filmRepository.findAll(sort).stream()
                       .map(film -> modelMapper.map(film, FilmRest.class))
                       .collect(Collectors.toList());

    }

    @Override
    public List<FilmRest> getFilmsSortedByDefault() {
        return filmRepository.findAllByOrderByYearDesc().stream()
                       .map(film -> modelMapper.map(film, FilmRest.class))
                       .collect(Collectors.toList());
    }

    @Override
    public List<FilmRest> getFilmsSortedProgrammatically() {

        final Sort sortProgrammatically = Sort.by(Sort.Direction.ASC, "year")
                                                  .and(Sort.by(Sort.Direction.DESC, "name"));

        return filmRepository.findAll(sortProgrammatically).stream()
                       .map(film -> modelMapper.map(film, FilmRest.class))
                       .collect(Collectors.toList());
    }

    @Override
    public List<FilmRest> getFilmsByCategorySortedDynamically(final Sort sort) {

        return filmRepository.findAllByCategory_Id(2, sort).stream()
                       .map(film -> modelMapper.map(film, FilmRest.class))
                       .collect(Collectors.toList());
    }
}
