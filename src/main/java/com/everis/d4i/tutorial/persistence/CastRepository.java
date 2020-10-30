package com.everis.d4i.tutorial.persistence;

import com.everis.d4i.tutorial.persistence.entity.CastEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CastRepository extends JpaRepository<CastEntity, Long> {
}
