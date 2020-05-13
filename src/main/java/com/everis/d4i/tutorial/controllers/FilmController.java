package com.everis.d4i.tutorial.controllers;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.FilmRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FilmController {

    NetflixResponse<Page<FilmRest>> getFilms(Pageable pageable) throws NetflixException;
}
