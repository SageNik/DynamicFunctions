package com.chisw.dynamicFunctions.service;

import com.chisw.dynamicFunctions.web.dto.ConfigDTO;

import java.util.List;

/**
 * This is class is used for realization business logic of that application
 */
public interface DynamicFunctionsService {

    /**
     * This method set initial data for using functions
     * @param configDTO incoming data from rest controller
     * @return "true" if initialization finished successful or "false" if not.
     */
    boolean initConfig(ConfigDTO configDTO);

    /**
     * This method get all available functions
     * @return List of found functions and containers
     */
    List<Object> getAvailableFunctions();
}
