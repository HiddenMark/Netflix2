package com.everis.d4i.tutorial.persistence.mapper;

import com.everis.d4i.tutorial.persistence.entity.CastEntity;
import com.everis.d4i.tutorial.service.dto.CastDto;
import com.everis.d4i.tutorial.service.dto.FilmDto;
import com.everis.d4i.tutorial.service.dto.PersonDto;
import com.everis.d4i.tutorial.service.dto.RoleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CastEntityMapper implements EntityMapper<CastEntity, CastDto> {

	private final PersonEntityMapper personEntityMapper;

	private final RoleEntityMapper roleEntityMapper;

	private final FilmEntityMapper filmEntityMapper;

	@Override
	public CastDto mapToDto(final CastEntity castEntity) {

		final Long id = castEntity.getId();
		final PersonDto personRest = personEntityMapper.mapToDto(castEntity.getPerson());
		final RoleDto roleRest = roleEntityMapper.mapToDto(castEntity.getRole());
		final FilmDto filmRest = filmEntityMapper.mapToDto(castEntity.getFilm());

		return new CastDto(id, personRest, roleRest, filmRest);
	}

}
