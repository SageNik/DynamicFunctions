package com.chisw.dynamicFunctions.persistence.jpa.repository;

import com.chisw.dynamicFunctions.entity.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for {@link Calculation} data implemented using Spring Data JPA.
 */
@Repository
public interface CalculationRepository extends JpaRepository<Calculation, Long> {

    @Query(value = "Select ca.* from calculation ca LEFT JOIN function  f ON ca.function_id = f.id " +
            "WHERE (ca.user_name = ?1 AND f.name = ?2 AND f.switched_on = TRUE AND f.available = TRUE " +
            "AND f.as_container = FALSE AND ca.x >= ?3 AND ca.x <= ?4)", nativeQuery = true)
    List<Calculation> findAllbyUsage(String userName, String functionName, Float x1, Float x2);
}
