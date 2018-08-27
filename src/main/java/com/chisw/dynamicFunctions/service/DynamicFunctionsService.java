package com.chisw.dynamicFunctions.service;

import com.chisw.dynamicFunctions.web.dto.ConfigDTO;
import com.chisw.dynamicFunctions.web.dto.FunctionDTO;

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
    List<FunctionDTO> getAvailableFunctions();

    /**
     * This method connect function for use
     * @param functionName name of connecting function
     * @param a argument
     * @param b argument
     * @return "true" if function connected successful or "false" if not.
     */
    boolean connectFunction(String functionName, Float a, Float b);

    /**
     * This method disconnect function from use
     * @param functionName name of disconnecting function
     * @return "true" if function disconnected successful or "false" if not.
     */
    boolean disconnectFunction(String functionName);
}
