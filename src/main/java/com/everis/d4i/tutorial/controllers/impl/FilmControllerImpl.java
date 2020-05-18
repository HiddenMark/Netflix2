package com.everis.d4i.tutorial.controllers.impl;

import com.everis.d4i.tutorial.controllers.FilmController;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.FilmRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;
import com.everis.d4i.tutorial.services.FilmService;
import com.everis.d4i.tutorial.utils.constants.CommonConstants;
import com.everis.d4i.tutorial.utils.constants.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_FILM)
public class FilmControllerImpl implements FilmController {

    @Autowired
    private FilmService filmService;

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public NetflixResponse<List<FilmRest>> getFilmsFilteredBy(final Integer categoryId) throws NetflixException {
        return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
                filmService.getFilmsFilteredBy());
    }
}
