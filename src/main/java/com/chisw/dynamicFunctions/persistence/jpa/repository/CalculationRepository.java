package com.chisw.dynamicFunctions.persistence.jpa.repository;

import com.chisw.dynamicFunctions.entity.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link Calculation} data implemented using Spring Data JPA.
 */
@Repository
public interface CalculationRepository extends JpaRepository<Calculation, Long> {
}
