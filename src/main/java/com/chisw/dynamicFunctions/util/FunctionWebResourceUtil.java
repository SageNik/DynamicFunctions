package com.chisw.dynamicFunctions.util;


import com.chisw.dynamicFunctions.entity.Function;
import com.chisw.dynamicFunctions.web.dto.FunctionDTO;

public class FunctionWebResourceUtil {

    public static FunctionDTO toDTO(Function function){

        FunctionDTO functionDTO= new FunctionDTO();
        functionDTO.setName(function.getName());
        return functionDTO;
    }
}
