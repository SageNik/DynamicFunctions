package com.chisw.dynamicFunctions.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class UsageBodyDTO {
   public String user;
   public String func;
   public Float x1;
   public Float x2;
}
