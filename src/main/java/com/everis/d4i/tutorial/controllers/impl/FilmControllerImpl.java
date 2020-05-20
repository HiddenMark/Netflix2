package com.everis.d4i.tutorial.controllers.impl;

import com.everis.d4i.tutorial.controllers.FilmController;
import com.everis.d4i.tutorial.json.FilmRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;
import com.everis.d4i.tutorial.services.FilmService;
import com.everis.d4i.tutorial.utils.constants.CommonConstants;
import com.everis.d4i.tutorial.utils.constants.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_FILM)
public class FilmControllerImpl implements FilmController {

    @Autowired
    private FilmService filmService;

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public NetflixResponse<List<FilmRest>> getFilmsFilteredDynamicallyBy(
            @RequestParam(name = "name", required = false) final String name,
            @RequestParam(name = "year", required = false) final Integer year,
            @RequestParam(name = "country", required = false) final String country,
            @RequestParam(name = "language", required = false) final List<String> languages,
            @RequestParam(name = "category", required = false) final Integer category,
            @RequestParam(name = "subcategory", required = false) final List<String> subcategories,
            @RequestParam(name = "mimum_duration", required = false) final Integer minimumDuration) {

        return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
                filmService.getDynamicallyFiltered(name,
                        year,
                        country,
                        languages,
                        category,
                        subcategories,
                        minimumDuration));

    }
}
