package com.everis.d4i.tutorial.controllers;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.CategoryRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;

import java.util.List;

public interface CategoryController {

	NetflixResponse<List<CategoryRest>> getCategories() throws NetflixException;

	NetflixResponse<CategoryRest> createCategory(final CategoryRest categoryRest) throws NetflixException;

}
