package com.chisw.dynamicFunctions.service;

import com.chisw.dynamicFunctions.entity.Function;
import com.chisw.dynamicFunctions.exception.FunctionNotFoundException;
import com.chisw.dynamicFunctions.entity.function.Container;
import com.chisw.dynamicFunctions.entity.function.PrimitiveFunction;
import com.chisw.dynamicFunctions.persistence.jpa.repository.ContainerRepository;
import com.chisw.dynamicFunctions.persistence.jpa.repository.FunctionRepository;
import com.chisw.dynamicFunctions.web.dto.ConfigDTO;
import com.chisw.dynamicFunctions.web.dto.ContainerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Profile("dev")
public class DynamicFunctionsServiceImpl implements DynamicFunctionsService {

    @Autowired
    private FunctionRepository functionRepository;
    @Autowired
    private ContainerRepository containerRepository;

    @Override
    public boolean initConfig(ConfigDTO configDTO) {

        if(configDTO != null){
            createPrimitiveFunctions(configDTO.getPrimitives(), null);
            for(ContainerDTO containerDTO : configDTO.getContainers()){
                Container container = new Container(containerDTO.getName());
                containerRepository.save(container);
                createPrimitiveFunctions(containerDTO.getFunctions(), container);
            }
            return true;
        }
        return false;
    }

    @Override
    public List<Object> getAvailableFunctions() {
        return null;
    }

    private void createPrimitiveFunctions(List<String> functionNames, Container container) {
        for(String functionName :functionNames){
            saveFunction(functionName, container);
        }
    }

    private void saveFunction(String functionName, Container container) {
        try {
            Function function = PrimitiveFunction.getFunction( functionName);
            function.setContainer(container);
            functionRepository.save(function);
        } catch (FunctionNotFoundException e) {
            e.printStackTrace();
        }
    }


}
