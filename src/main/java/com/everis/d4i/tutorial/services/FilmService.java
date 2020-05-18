package com.everis.d4i.tutorial.services;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.FilmRest;

import java.util.List;

public interface FilmService {

	List<FilmRest> getFilmsFilteredBy(Integer categoryId) throws NetflixException;

}
