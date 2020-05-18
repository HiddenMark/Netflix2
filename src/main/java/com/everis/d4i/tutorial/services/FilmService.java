package com.everis.d4i.tutorial.services;

import com.everis.d4i.tutorial.json.FilmRest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface FilmService {

	Page<FilmRest> getPageOfFilms(Pageable pageable);

	Slice<FilmRest> getFilmsByCategorySliced(Integer categoryId, Pageable pageable);

	List<FilmRest> getFilmsByDurationGreaterThanListed(Integer duration, Pageable pageable);
}
