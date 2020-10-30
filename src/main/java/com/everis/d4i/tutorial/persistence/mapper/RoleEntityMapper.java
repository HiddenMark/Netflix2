package com.everis.d4i.tutorial.persistence.mapper;

import com.everis.d4i.tutorial.persistence.entity.RoleEntity;
import com.everis.d4i.tutorial.service.dto.RoleDto;
import org.springframework.stereotype.Component;

@Component
public class RoleEntityMapper implements EntityMapper<RoleEntity, RoleDto> {

	@Override
	public RoleDto mapToDto(final RoleEntity roleEntity) {

		final Long id = roleEntity.getId();
		final String name = roleEntity.getName();

		return new RoleDto(id, name);
	}

}
