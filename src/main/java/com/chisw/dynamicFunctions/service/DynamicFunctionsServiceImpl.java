package com.chisw.dynamicFunctions.service;

import com.chisw.dynamicFunctions.entity.Function;
import com.chisw.dynamicFunctions.exception.FunctionNotFoundException;
import com.chisw.dynamicFunctions.entity.function.Container;
import com.chisw.dynamicFunctions.entity.function.PrimitiveFunction;
import com.chisw.dynamicFunctions.persistence.jpa.repository.FunctionRepository;
import com.chisw.dynamicFunctions.util.FunctionWebResourceUtil;
import com.chisw.dynamicFunctions.web.dto.ConfigDTO;
import com.chisw.dynamicFunctions.web.dto.ContainerDTO;
import com.chisw.dynamicFunctions.web.dto.FunctionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DynamicFunctionsServiceImpl implements DynamicFunctionsService {

    @Autowired
    private FunctionRepository functionRepository;

    @Override
    public boolean initConfig(ConfigDTO configDTO) {

        if(configDTO != null){
            createPrimitiveFunctions(configDTO.getPrimitives(), null);
            for(ContainerDTO containerDTO : configDTO.getContainers()){
                Container container = new Container(containerDTO.getName());
                functionRepository.save(container);
                createPrimitiveFunctions(containerDTO.getFunctions(), container);
            }
            return true;
        }
        return false;
    }

    @Override
    public List<FunctionDTO> getAvailableFunctions() {
        List<FunctionDTO> functionDTOList = new ArrayList<>();
            List<Function> functions = functionRepository.findAllByAvailableAndContainerId(true, null);
            functionDTOList.addAll(functions.stream().map(FunctionWebResourceUtil::toDTO).collect(Collectors.toList()));
        return functionDTOList;
    }

    @Override
    public boolean connectFunction(String functionName, Float a, Float b) {
         Function function = functionRepository.findByNameAndAvailableAndContainerIdAndSwitchedOn(functionName, true,null, false);
        if(function == null) return false;
        else {
            function.switchOn(a,b);
            return true;
        }
    }

    @Override
    public boolean disconnectFunction(String functionName) {
        Function function = functionRepository.findByNameAndAvailableAndContainerIdAndSwitchedOn(functionName, true,null, true);
        if(function == null) return false;
        else {
            function.switchOff();
        return true;
        }
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
