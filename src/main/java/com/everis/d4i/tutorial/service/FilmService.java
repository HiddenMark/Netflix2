package com.everis.d4i.tutorial.service;

import com.everis.d4i.tutorial.exception.NetflixException;
import com.everis.d4i.tutorial.service.dto.FilmDto;

import java.util.Collection;

public interface FilmService {

	Collection<FilmDto> getFilms(Collection<String> categoryNameCollection, Collection<String> languageCollection)
			throws NetflixException;

}
