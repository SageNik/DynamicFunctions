package com.chisw.dynamicFunctions.persistence.jpa.repository;

import com.chisw.dynamicFunctions.entity.Function;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for {@link com.chisw.dynamicFunctions.entity.Function} data implemented using Spring Data JPA.
 */
public interface FunctionRepository extends JpaRepository<Function,Long>{
}
