package com.everis.d4i.tutorial.controller;

import com.everis.d4i.tutorial.controller.rest.FilmRest;
import com.everis.d4i.tutorial.controller.rest.response.NetflixResponse;
import com.everis.d4i.tutorial.exception.NetflixException;

import java.util.Collection;

public interface FilmController {

	NetflixResponse<FilmRest[]> getFilms(Collection<String> categoryNameCollection, Collection<String> languageCollection)
			throws NetflixException;
}
