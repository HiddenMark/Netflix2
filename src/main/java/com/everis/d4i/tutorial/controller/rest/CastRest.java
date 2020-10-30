package com.everis.d4i.tutorial.controller.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class CastRest implements Serializable {

	private static final long serialVersionUID = 180802329621611101L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("person")
	private PersonRest person;

	@JsonProperty("role")
	private RoleRest role;

	@JsonProperty("film")
	private FilmRest film;

}
