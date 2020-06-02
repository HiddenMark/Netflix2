package com.everis.d4i.tutorial.services;

import com.everis.d4i.tutorial.json.FilmRest;
import com.everis.d4i.tutorial.json.FilteringParameters;

import java.util.List;

public interface FilmService {

    List<FilmRest> getFilmsFilteredByMinimumDuration(Integer duration);

    List<FilmRest> getDynamicallyFiltered(FilteringParameters filters);
}
