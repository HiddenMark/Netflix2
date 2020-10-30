package com.everis.d4i.tutorial.controller.mapper;

import com.everis.d4i.tutorial.controller.rest.RoleRest;
import com.everis.d4i.tutorial.service.dto.RoleDto;
import org.springframework.stereotype.Component;

@Component
public class RoleRestMapper  implements RestMapper<RoleRest, RoleDto>{

	@Override
	public RoleRest mapToRest(final RoleDto roleDto) {

		final Long id = roleDto.getId();
		final String name = roleDto.getName();

		return new RoleRest(id, name);
	}

}
