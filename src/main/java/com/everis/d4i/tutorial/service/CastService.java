package com.everis.d4i.tutorial.service;

import com.everis.d4i.tutorial.exception.NetflixException;
import com.everis.d4i.tutorial.service.dto.CastDto;

import java.util.Collection;

public interface CastService {

	Collection<CastDto> getAllCasts() throws NetflixException;

}
