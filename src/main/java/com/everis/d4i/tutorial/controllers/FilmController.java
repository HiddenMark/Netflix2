package com.everis.d4i.tutorial.controllers;

import com.everis.d4i.tutorial.json.FilmRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;

import java.util.List;

public interface FilmController {

    NetflixResponse<List<FilmRest>> getFilmsFilteredDynamicallyBy(String name,
                                                                  Integer year,
                                                                  String country,
                                                                  List<String> languages,
                                                                  Integer category,
                                                                  List<String> subcategories,
                                                                  Integer minimumDuration);
}
