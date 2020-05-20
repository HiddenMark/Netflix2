package com.everis.d4i.tutorial.persistence.specifications;

import com.everis.d4i.tutorial.persistence.entities.Film;
import org.springframework.data.jpa.domain.Specification;

public class ReusableFilmSpecifications {

    private ReusableFilmSpecifications() {
        throw new IllegalStateException("Utility class");
    }

    public static Specification<Film> hasName(final String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<Film> isYearEqual(final Integer year) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("year"), year);
    }

    public static Specification<Film> hasShortDescription(final String subcategory) {
        return ((root, query, criteriaBuilder)
                        -> criteriaBuilder.like(root.get("shortDescription"), "%" + subcategory + "%"));
    }

    public static Specification<Film> isCategoryEqual(final Integer categoryId) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("category"), categoryId));
    }
}
