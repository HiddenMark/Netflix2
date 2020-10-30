package com.everis.d4i.tutorial.controller.impl;

import com.everis.d4i.tutorial.controller.FilmController;
import com.everis.d4i.tutorial.controller.mapper.FilmRestMapper;
import com.everis.d4i.tutorial.controller.rest.FilmRest;
import com.everis.d4i.tutorial.controller.rest.response.NetflixResponse;
import com.everis.d4i.tutorial.exception.NetflixException;
import com.everis.d4i.tutorial.service.FilmService;
import com.everis.d4i.tutorial.util.constant.CommonConstants;
import com.everis.d4i.tutorial.util.constant.RestConstants;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1)
@RequiredArgsConstructor
public class FilmControllerImpl implements FilmController {

	private final FilmService filmService;

	private final FilmRestMapper filmRestMapper;

	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = RestConstants.RESOURCE_FILM, produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<FilmRest[]> getFilms(
			@RequestParam(name = "category", required = false, defaultValue = "") final Collection<String> categoryNameCollection,
			@RequestParam(name = "language", required = false, defaultValue = "") final Collection<String> languageCollection)
			throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				filmService.getFilms(categoryNameCollection, languageCollection).parallelStream()
						.map(filmRestMapper::mapToRest).toArray(FilmRest[]::new));
	}

	@Override
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = RestConstants.RESOURCE_FILM, produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<FilmRest> createFilm(
			@ApiParam(value = RestConstants.PARAMETER_FILM, required = true) @RequestBody @Valid final FilmRest filmRest)
			throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.CREATED), CommonConstants.OK,
				filmRestMapper.mapToRest(filmService.create(filmRestMapper.mapToDto(filmRest))));
	}

}
