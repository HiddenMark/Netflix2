package com.everis.d4i.tutorial.controller.mapper;

import com.everis.d4i.tutorial.controller.rest.PersonRest;
import com.everis.d4i.tutorial.service.dto.PersonDto;
import org.springframework.stereotype.Component;

@Component
public class PersonRestMapper implements RestMapper<PersonRest, PersonDto> {

	@Override
	public PersonRest mapToRest(final PersonDto personDto) {

		final Long id = personDto.getId();
		final String name = personDto.getName();
		final String surname = personDto.getSurname();
		final String year = personDto.getYear();

		return new PersonRest(id, name, surname, year);
	}

}
