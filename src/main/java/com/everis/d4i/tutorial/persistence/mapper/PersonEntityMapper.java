package com.everis.d4i.tutorial.persistence.mapper;

import com.everis.d4i.tutorial.persistence.entity.PersonEntity;
import com.everis.d4i.tutorial.service.dto.PersonDto;
import org.springframework.stereotype.Component;

@Component
public class PersonEntityMapper implements EntityMapper<PersonEntity, PersonDto> {

	@Override
	public PersonDto mapToDto(final PersonEntity personEntity) {

		final Long id = personEntity.getId();
		final String name = personEntity.getName();
		final String surname = personEntity.getSurname();
		final String year = personEntity.getYear().toString();

		return new PersonDto(id, name, surname, year);
	}

}
