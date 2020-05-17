package com.everis.d4i.tutorial.controllers;

import com.everis.d4i.tutorial.json.FilmRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface FilmController {

    NetflixResponse<Slice<FilmRest>> getFilms(Pageable pageable);

}
