package com.chisw.dynamicFunctions.service;


import com.chisw.dynamicFunctions.entity.Function;
import com.chisw.dynamicFunctions.entity.function.Container;
import com.chisw.dynamicFunctions.persistence.jpa.repository.CalculationRepository;
import com.chisw.dynamicFunctions.persistence.jpa.repository.FunctionRepository;
import com.chisw.dynamicFunctions.service.impl.DynamicFunctionsServiceImpl;
import com.chisw.dynamicFunctions.service.interfaces.DynamicFunctionsService;
import com.chisw.dynamicFunctions.web.dto.ConfigDTO;
import com.chisw.dynamicFunctions.web.dto.ContainerDTO;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DynamicFunctionsServiceImplUnitTest {

    private FunctionRepository functionRepository;
    private CalculationRepository calculationRepository;
    private DynamicFunctionsService dynamicFunctionsService;

    @Before
    public void init(){
        functionRepository = mock(FunctionRepository.class);
        calculationRepository = mock(CalculationRepository.class);
        dynamicFunctionsService = new DynamicFunctionsServiceImpl(functionRepository,calculationRepository);
    }

    @Test
    public void initConfig_success(){

        String name = "container1";
        Function container = new Container(name);
        ContainerDTO containerDTO = new ContainerDTO();
        containerDTO.setName(name);
        ConfigDTO configDTO = new ConfigDTO();
        configDTO.getContainers().add(containerDTO);
        when(functionRepository.save(container)).thenReturn(container);

        boolean result = dynamicFunctionsService.initConfig(configDTO);
        assertTrue(result);

    }
}
