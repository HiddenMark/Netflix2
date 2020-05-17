package com.everis.d4i.tutorial.services;

import com.everis.d4i.tutorial.json.FilmRest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface FilmService {

	Page<FilmRest> getPageOfFilms(Pageable pageable);

	Slice<FilmRest> getFilmsByCategorySliced(Integer categoryId, Pageable pageable);
}
