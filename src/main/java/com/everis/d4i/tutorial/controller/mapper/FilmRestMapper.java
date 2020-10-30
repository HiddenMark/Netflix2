package com.everis.d4i.tutorial.controller.mapper;

import com.everis.d4i.tutorial.controller.rest.CategoryRest;
import com.everis.d4i.tutorial.controller.rest.FilmRest;
import com.everis.d4i.tutorial.service.dto.CategoryDto;
import com.everis.d4i.tutorial.service.dto.FilmDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FilmRestMapper implements RestMapper<FilmRest, FilmDto>{

	private final CategoryRestMapper categoryRestMapper;

	@Override
	public FilmRest mapToRest(final FilmDto filmDto) {

		final Long id = filmDto.getId();
		final String name = filmDto.getName();
		final Integer year = filmDto.getYear();
		final String country = filmDto.getCountry();
		final String language = filmDto.getLanguage();
		final Integer duration = filmDto.getDuration();
		final String shortDescription = filmDto.getShortDescription();
		final String longDescription = filmDto.getLongDescription();
		final CategoryRest category = categoryRestMapper.mapToRest(filmDto.getCategory());

		return new FilmRest(id, name, year, country, language, duration, shortDescription, longDescription, category);
	}

	@Override
	public FilmDto mapToDto(final FilmRest filmRest) {

		final Long id = filmRest.getId();
		final String name = filmRest.getName();
		final Integer year = filmRest.getYear();
		final String country = filmRest.getCountry();
		final String language = filmRest.getLanguage();
		final Integer duration = filmRest.getDuration();
		final String shortDescription = filmRest.getShortDescription();
		final String longDescription = filmRest.getLongDescription();
		final CategoryDto category = categoryRestMapper.mapToDto(filmRest.getCategory());

		return new FilmDto(id, name, year, country, language, duration, shortDescription, longDescription, category);
	}

}
