package com.chisw.dynamicFunctions.persistence.jpa.repository;

import com.chisw.dynamicFunctions.entity.Function;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository for {@link com.chisw.dynamicFunctions.entity.Function} data implemented using Spring Data JPA.
 */
public interface FunctionRepository extends JpaRepository<Function,Long>{
    List<Function> findAllByAvailableAndContainerId(Boolean available, Long containerId);

    Function findByNameAndAvailableAndContainerIdAndSwitchedOn(String functionName, Boolean available, Long containerId, Boolean switchedOn);
}
