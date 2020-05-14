package com.everis.d4i.tutorial.services;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.FilmRest;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface FilmService {

	List<FilmRest> getFilms(Sort sort) throws NetflixException;

}
