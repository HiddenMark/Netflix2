package com.everis.d4i.tutorial.services;

import com.everis.d4i.tutorial.json.FilmRest;

import java.util.List;

public interface FilmService {

    List<FilmRest> getFilmsFilteredByMinimumDuration(Integer duration);

    List<FilmRest> getDynamicallyFiltered(String name,
                                          Integer year,
                                          String country,
                                          List<String> languages,
                                          Integer category,
                                          List<String> subcategories,
                                          Integer minimumDuration);
}
