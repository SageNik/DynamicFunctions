package com.chisw.dynamicFunctions.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class UsageBodyDTO {
   private String user;
   private Float x1;
   private Float x2;
   private String func;
}
