package com.everis.d4i.tutorial.controller.mapper;

import com.everis.d4i.tutorial.controller.rest.CastRest;
import com.everis.d4i.tutorial.controller.rest.FilmRest;
import com.everis.d4i.tutorial.controller.rest.PersonRest;
import com.everis.d4i.tutorial.controller.rest.RoleRest;
import com.everis.d4i.tutorial.service.dto.CastDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CastRestMapper implements RestMapper<CastRest, CastDto> {

	private final PersonRestMapper personRestMapper;

	private final RoleRestMapper roleRestMapper;

	private final FilmRestMapper filmRestMapper;

	@Override
	public CastRest mapToRest(final CastDto castDto) {

		final Long id = castDto.getId();
		final PersonRest personRest = personRestMapper.mapToRest(castDto.getPerson());
		final RoleRest roleRest = roleRestMapper.mapToRest(castDto.getRole());
		final FilmRest filmRest = filmRestMapper.mapToRest(castDto.getFilm());

		return new CastRest(id, personRest, roleRest, filmRest);
	}

}
