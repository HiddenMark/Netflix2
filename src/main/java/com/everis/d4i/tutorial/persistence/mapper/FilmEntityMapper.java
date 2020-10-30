package com.everis.d4i.tutorial.persistence.mapper;

import com.everis.d4i.tutorial.persistence.entity.CategoryEntity;
import com.everis.d4i.tutorial.persistence.entity.FilmEntity;
import com.everis.d4i.tutorial.service.dto.CategoryDto;
import com.everis.d4i.tutorial.service.dto.FilmDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Year;
import java.util.Collections;

@Component
@RequiredArgsConstructor
public class FilmEntityMapper implements EntityMapper<FilmEntity, FilmDto> {

	private final CategoryEntityMapper categoryEntityMapper;

	@Override
	public FilmDto mapToDto(final FilmEntity filmEntity) {

		final Long id = filmEntity.getId();
		final String name = filmEntity.getName();
		final Integer year = Integer.parseInt(filmEntity.getYear().toString());
		final String country = filmEntity.getCountry();
		final String language = filmEntity.getLanguage();
		final Integer duration = filmEntity.getDuration();
		final String shortDescription = filmEntity.getShortDescription();
		final String longDescription = filmEntity.getLongDescription();
		final CategoryDto category = categoryEntityMapper.mapToDto(filmEntity.getCategory());

		return new FilmDto(id, name, year, country, language, duration, shortDescription, longDescription, category);
	}

	@Override
	public FilmEntity mapToEntity(final FilmDto filmDto) {

		final Long id = filmDto.getId();
		final String name = filmDto.getName();
		final Year year = Year.of(filmDto.getYear());
		final String country = filmDto.getCountry();
		final String language = filmDto.getLanguage();
		final Integer duration = filmDto.getDuration();
		final String shortDescription = filmDto.getShortDescription();
		final String longDescription = filmDto.getLongDescription();
		final CategoryEntity categoryEntity = categoryEntityMapper.mapToEntity(filmDto.getCategory());

		return new FilmEntity(id, name, year, country, language, duration, shortDescription, longDescription, categoryEntity, Collections.emptyList());
	}


}
