package com.everis.d4i.tutorial.persistence.specification;

import com.everis.d4i.tutorial.persistence.entity.CategoryEntity;
import com.everis.d4i.tutorial.persistence.entity.CategoryEntity_;
import com.everis.d4i.tutorial.persistence.entity.FilmEntity_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.JoinType;

@Component
public class CategorySpecification {

	/*
		SELECT DISTINCT C.*
		FROM films  F
		JOIN categories C ON F.category_id = C.id;
	 */

	public Specification<CategoryEntity> withFilms() {
		return (category, query, cb) -> {
			// JOIN categories c ON F.category_id = C.id;
			final CriteriaBuilder.In<Object> value = cb.in(
					category.join(CategoryEntity_.FILMS, JoinType.INNER).get(FilmEntity_.CATEGORY).get(CategoryEntity_.ID)
			).value(category.get(CategoryEntity_.ID));
			// DISTINCT
			query.distinct(true);
			return value;
		};
	}

}
