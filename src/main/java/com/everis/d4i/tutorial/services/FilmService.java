package com.everis.d4i.tutorial.services;

import com.everis.d4i.tutorial.json.FilmRest;

import java.util.List;

public interface FilmService {

	List<FilmRest> getFilmsFilteredByMinimumDuration(Integer duration);

	List<FilmRest> getFilmsByCategoryAndSubcategory(Integer categoryId, String subcategory);

	List<FilmRest> getFilmsByYearAndCategoryNameWithNativeQuery(Integer year, String categoryName);

	List<FilmRest> getFilmsByYearAndCategoryNameWithJPQLQuery(Integer year, String categoryName);
}
