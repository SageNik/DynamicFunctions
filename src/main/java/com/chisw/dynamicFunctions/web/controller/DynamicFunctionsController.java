package com.chisw.dynamicFunctions.web.controller;

import com.chisw.dynamicFunctions.service.DynamicFunctionsService;
import com.chisw.dynamicFunctions.web.dto.ConfigDTO;
import com.chisw.dynamicFunctions.web.dto.FunctionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A RESTFul web for accessing dynamic function information.
 */
@RestController
@RequestMapping(value = "/")
public class DynamicFunctionsController {

    private DynamicFunctionsService service;

    @Autowired
    public DynamicFunctionsController(DynamicFunctionsService service) {
        this.service = service;
    }

    @RequestMapping(value = "initialConfig",method = RequestMethod.POST)
    public ResponseEntity initial(@RequestBody ConfigDTO configDTO){
        if(service.initConfig(configDTO)) return new ResponseEntity(HttpStatus.OK);
        else return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "getAvail", method = RequestMethod.GET)
    public ResponseEntity getAvailable(){
        List<FunctionDTO> functions = service.getAvailableFunctions();
        return new ResponseEntity<>(functions, HttpStatus.OK);
    }

    @RequestMapping(value = "connect", method = RequestMethod.POST)
    public ResponseEntity connect(@RequestParam("name")String functionName, @RequestParam("a")String a, @RequestParam("b")String b){
        if(functionName == null || a == null || b == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            if(service.connectFunction(functionName, Float.valueOf(a), Float.valueOf(b)))return new ResponseEntity<>("The function with name: "+functionName+ " has been successfully connected",HttpStatus.OK);
            else return new ResponseEntity<>("Sorry, the function with name: "+functionName+ " hasn't been found",HttpStatus.OK);
        }
    }

    @RequestMapping(value = "disconnect", method = RequestMethod.POST)
    public ResponseEntity disconnect(@RequestParam("name")String functionName){
        if(service.disconnectFunction(functionName))return new ResponseEntity<>("The function with name: "+functionName+ " has been successfully disconnected",HttpStatus.OK);
        else return new ResponseEntity<>("Sorry, the function with name: "+functionName+ " hasn't been found",HttpStatus.OK);
    }

    @RequestMapping(value = "getConfig")
    public ResponseEntity getConfig(){
        return  null;
    }

    @RequestMapping(value = "eval")
    public ResponseEntity evaluate(){
        return  null;
    }

    @RequestMapping(value = "getUsage")
    public ResponseEntity getUsage(){
        return  null;
    }

    @RequestMapping(value = "getDisconnected")
    public ResponseEntity getDisconnected(){
        return  null;
    }

    @RequestMapping(value = "getMaxUser")
    public ResponseEntity getMaxUser(){
        return  null;
    }
}
