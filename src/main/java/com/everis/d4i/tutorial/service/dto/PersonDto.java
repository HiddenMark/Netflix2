package com.everis.d4i.tutorial.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDto implements Serializable {

	private static final long serialVersionUID = 8545052880331469018L;

	private Long id;

	private String name;

	private String surname;

	private String year;

}
