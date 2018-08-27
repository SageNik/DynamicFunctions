package com.chisw.dynamicFunctions.entity.function;

import com.chisw.dynamicFunctions.entity.Function;
import lombok.Data;

import javax.persistence.Entity;

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
    public Float evaluate(Float x) {
        for(Function function : functions){
            function.evaluate(x);
        }
        return x;
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
