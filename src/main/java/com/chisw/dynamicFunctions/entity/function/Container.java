package com.chisw.dynamicFunctions.entity.function;

import com.chisw.dynamicFunctions.entity.Calculation;
import com.chisw.dynamicFunctions.entity.Function;
import lombok.Data;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Persistent Container entity with JPA markup.
 */
@Entity
@Data
public class Container extends Function {

    public Container(){super();}
    public Container(String name) {
        super(name);
        this.asContainer = true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Calculation evaluate(Float x, String userName) {
        this.calculations = new ArrayList<>();
        for(Function function : functions){
            Calculation calc = function.evaluate(x, userName);
            this.getCalculations().add(calc);
        }
        return new Calculation(this.getName(),userName,null,x);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void switchOn(Float a, Float b) {
        this.switchedOn = true;
        this.a = a;
        this.b = b;
        for(Function function : functions){
             function.switchOn(a,b);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void switchOff() {
        this.switchedOn = false;
        this.a = null;
        this.b = null;
        for(Function function : functions){
            function.switchOff();
        }
    }

    /**
     * This method add primitive function to container
     */
    void addFunction(PrimitiveFunction function){
        functions.add(function);
        function.setContainer(this);
    }

    /**
     * This method remove primitive function from container
     */
    void removeFunction (PrimitiveFunction function){
        functions.remove(function);
    }

}
