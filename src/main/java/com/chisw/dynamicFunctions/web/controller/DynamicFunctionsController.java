package com.chisw.dynamicFunctions.web.controller;

import com.chisw.dynamicFunctions.DynamicFunctionsServer;
import com.chisw.dynamicFunctions.service.DynamicFunctionsService;
import com.chisw.dynamicFunctions.web.dto.ConfigDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * A RESTFul web for accessing dynamic function information.
 */
@Controller
@RequestMapping(name = "/")
public class DynamicFunctionsController {

    private DynamicFunctionsService service;

    @Autowired
    public DynamicFunctionsController(DynamicFunctionsService service) {
        this.service = service;
    }

    @RequestMapping(name = "initialConfig")
    public ResponseEntity initial(@RequestBody ConfigDTO configDTO){
        if(service.initConfig(configDTO)) return new ResponseEntity(HttpStatus.OK);
        else return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(name = "getAvail")
    @ResponseBody
    public ResponseEntity getAvailable(){
        List<Object> objects = service.getAvailableFunctions();
        return new ResponseEntity<Object>(objects, HttpStatus.OK);
    }

    @RequestMapping(name = "connect")
    public ResponseEntity connect(){
    return  null;
    }

    @RequestMapping(name = "disconnect")
    public ResponseEntity disconnect(){
        return  null;
    }

    @RequestMapping(name = "getConfig")
    public ResponseEntity getConfig(){
        return  null;
    }

    @RequestMapping(name = "eval")
    public ResponseEntity evaluate(){
        return  null;
    }

    @RequestMapping(name = "getUsage")
    public ResponseEntity getUsage(){
        return  null;
    }

    @RequestMapping(name = "getDisconnected")
    public ResponseEntity getDisconnected(){
        return  null;
    }

    @RequestMapping(name = "getMaxUser")
    public ResponseEntity getMaxUser(){
        return  null;
    }
}
