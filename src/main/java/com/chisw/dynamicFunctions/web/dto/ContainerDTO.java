package com.chisw.dynamicFunctions.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ContainerDTO {

    private String name;
    private List<String> functions;

}
