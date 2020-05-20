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
    public NetflixResponse<List<FilmRest>> getFilmsFilteredStaticallyBy(
            @RequestParam(name = "minimumDuration", required = false) final Integer minimumDuration) {
        /* In this controller, only a parameter is collected: duration.
         The rest of examples are commented. Comment/uncomment to explore the other options.
         All the other returns call the functions with static values; should we want to collect from the user
         the filtering values, the controller signature and method call should be changed. Feel free to do so ;)
         */

        return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
                filmService.getFilmsFilteredByMinimumDuration(minimumDuration));

//        return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
//                filmService.getFilmsByCategoryAndSubcategory(3, "black"));

//        return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
//                filmService.getFilmsByYearAndCategoryNameWithJPQLQuery(2018, "drama"));

//                return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
//                filmService.getFilmsByYearAndCategoryNameWithNativeQuery(2018, "drama"));
    }
}
