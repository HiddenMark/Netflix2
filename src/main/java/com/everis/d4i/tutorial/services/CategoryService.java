package com.everis.d4i.tutorial.services;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.CategoryRest;

import java.util.List;

public interface CategoryService {

	List<CategoryRest> getCategories() throws NetflixException;

	CategoryRest createCategories(final CategoryRest categoryRest) throws NetflixException;
}
