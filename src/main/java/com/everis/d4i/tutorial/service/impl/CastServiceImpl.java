package com.everis.d4i.tutorial.service.impl;

import com.everis.d4i.tutorial.exception.NetflixException;
import com.everis.d4i.tutorial.persistence.CastRepository;
import com.everis.d4i.tutorial.persistence.mapper.CastEntityMapper;
import com.everis.d4i.tutorial.service.CastService;
import com.everis.d4i.tutorial.service.dto.CastDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CastServiceImpl implements CastService {

	private final CastRepository castRepository;

	private final CastEntityMapper castEntityMapper;

	@Override
	public Collection<CastDto> getAllCasts() throws NetflixException {
		return castRepository.findAll().parallelStream().map(castEntityMapper::mapToDto).collect(Collectors.toList());
	}
}
