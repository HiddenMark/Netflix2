package com.everis.d4i.tutorial.persistence.specification;

import com.everis.d4i.tutorial.persistence.entity.CategoryEntity;
import com.everis.d4i.tutorial.persistence.entity.CategoryEntity_;
import com.everis.d4i.tutorial.persistence.entity.FilmEntity;
import com.everis.d4i.tutorial.persistence.entity.FilmEntity_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import java.util.Collection;

@Component
public class FilmSpecification {

	/*
		SELECT F.*
		FROM films  F
		JOIN categories C ON F.category_id = C.id
		WHERE C.name IN( 'documentary', 'drama') AND F.language IN ('English', 'Polish');
	 */

	public Specification<FilmEntity> withCategoryName(final Collection<String> categoryNameCollection) {
		return (film, query, cb) -> {
			if (!categoryNameCollection.isEmpty()) {
				// JOIN categories C ON F.category_id = C.id
				final Join<FilmEntity, CategoryEntity> categoriesWithFilms = film.join(FilmEntity_.CATEGORY, JoinType.INNER);
				// WHERE C.name IN( 'documentary', 'drama')
				final CriteriaBuilder.In<Object> categoryInPredicate = cb.in(
						categoriesWithFilms.get(CategoryEntity_.NAME)).value(categoryNameCollection);
				return cb.and(categoryInPredicate);
			}
			return null;
		};
	}

	public Specification<FilmEntity> withLanguage(final Collection<String> languageCollection) {
		// WHERE F.language IN ('English', 'Polish');
		return (film, query, cb) -> languageCollection.isEmpty() ? null :
				cb.in(film.get(FilmEntity_.LANGUAGE)).value(languageCollection);
	}

	public Specification<FilmEntity> withCasts() {
		return (film, query, cb) -> cb.isNotEmpty(film.get(FilmEntity_.CASTS));
	}

}
