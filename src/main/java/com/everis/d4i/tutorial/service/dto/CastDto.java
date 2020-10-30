package com.everis.d4i.tutorial.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CastDto implements Serializable {

	private static final long serialVersionUID = 180802329621611101L;

	private Long id;

	private PersonDto person;

	private RoleDto role;

	private FilmDto film;

}
