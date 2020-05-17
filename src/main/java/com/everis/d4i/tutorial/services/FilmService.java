package com.everis.d4i.tutorial.services;

import com.everis.d4i.tutorial.json.FilmRest;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface FilmService {

	List<FilmRest> getFilmsSortedDynamically(Sort sort);

	List<FilmRest> getFilmsSortedByDefault();

	List<FilmRest> getFilmsSortedProgrammatically();

	List<FilmRest> getFilmsByCategorySortedDynamically(Sort sort);
}
