package com.everis.d4i.tutorial.service.impl;

import com.everis.d4i.tutorial.exception.NetflixException;
import com.everis.d4i.tutorial.persistence.FilmRepository;
import com.everis.d4i.tutorial.persistence.entity.FilmEntity;
import com.everis.d4i.tutorial.persistence.mapper.FilmEntityMapper;
import com.everis.d4i.tutorial.persistence.specification.FilmSpecification;
import com.everis.d4i.tutorial.service.FilmService;
import com.everis.d4i.tutorial.service.dto.FilmDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

	private final FilmRepository filmRepository;

	private final FilmEntityMapper filmEntityMapper;

	private final FilmSpecification filmSpecification;

	@Override
	public Collection<FilmDto> getFilms(final Collection<String> categoryNameCollection, final Collection<String> languageCollection) {

		final Specification<FilmEntity> spec = filmSpecification.withCategoryName(categoryNameCollection)
				.and(filmSpecification.withLanguage(languageCollection));

		return filmRepository.findAll(spec).parallelStream().map(filmEntityMapper::mapToDto)
				.collect(Collectors.toList());
	}

	@Override
	public FilmDto create(final FilmDto filmDto) throws NetflixException {
		return filmEntityMapper.mapToDto(filmRepository.save(filmEntityMapper.mapToEntity(filmDto)));
	}
}
