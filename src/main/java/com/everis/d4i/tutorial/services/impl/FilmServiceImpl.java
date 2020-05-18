package com.everis.d4i.tutorial.services.impl;

import com.everis.d4i.tutorial.json.FilmRest;
import com.everis.d4i.tutorial.persistence.FilmRepository;
import com.everis.d4i.tutorial.services.FilmService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository filmRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Page<FilmRest> getPageOfFilms(final Pageable pageable) {
        return filmRepository.findAll(pageable).map(film -> modelMapper.map(film, FilmRest.class));
    }

    @Override
    public Slice<FilmRest> getFilmsByCategorySliced(final Integer categoryId, final Pageable pageable) {
        return filmRepository.findAllByCategory_Id(2, pageable).map(film -> modelMapper.map(film, FilmRest.class));
    }

    @Override
    public List<FilmRest> getFilmsByDurationGreaterThanListed(final Integer duration, final Pageable pageable) {
        return filmRepository.findAllByDurationGreaterThan(duration, pageable).stream()
                       .map(film -> modelMapper.map(film, FilmRest.class))
                       .collect(Collectors.toList());
    }
}
