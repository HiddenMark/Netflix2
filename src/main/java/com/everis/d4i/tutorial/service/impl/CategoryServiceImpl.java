package com.everis.d4i.tutorial.service.impl;

import com.everis.d4i.tutorial.exception.NetflixException;
import com.everis.d4i.tutorial.exception.NotFoundException;
import com.everis.d4i.tutorial.persistence.CategoryRepository;
import com.everis.d4i.tutorial.persistence.entity.CategoryEntity;
import com.everis.d4i.tutorial.persistence.mapper.CategoryEntityMapper;
import com.everis.d4i.tutorial.persistence.specification.CategorySpecification;
import com.everis.d4i.tutorial.service.CategoryService;
import com.everis.d4i.tutorial.service.dto.CategoryDto;
import com.everis.d4i.tutorial.util.constant.ExceptionConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;

	private final CategoryEntityMapper categoryEntityMapper;

	private final CategorySpecification categorySpecification;

	@Override
	public Collection<CategoryDto> getCategories() {
		final Specification<CategoryEntity> spec = categorySpecification.withFilms();
		return categoryRepository.findAll(spec).parallelStream().map(categoryEntityMapper::mapToDto)
				.collect(Collectors.toList());
	}

	@Override
	public CategoryDto createCategory(final CategoryDto categoryDto) {
		return categoryEntityMapper.mapToDto(categoryRepository.save(categoryEntityMapper.mapToEntity(categoryDto)));
	}

	@Override
	public CategoryDto findById(final Long id) throws NetflixException {
		return categoryEntityMapper.mapToDto(categoryRepository.findById(id).orElseThrow(() ->
				new NotFoundException(ExceptionConstants.NOT_FOUND)));
	}

}
