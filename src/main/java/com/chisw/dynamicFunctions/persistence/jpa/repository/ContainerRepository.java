package com.chisw.dynamicFunctions.persistence.jpa.repository;

import com.chisw.dynamicFunctions.entity.function.Container;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link Container} data implemented using Spring Data JPA.
 */
@Repository
public interface ContainerRepository extends JpaRepository<Container, Long>{
}
