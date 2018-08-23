package com.chisw.dynamicFunctions.entity.function;

import com.chisw.dynamicFunctions.entity.Function;

/**
 * Persistent Container entity with JPA markup.
 */
public class Container extends Function {


    public Container(String name) {
        super(name);
        this.asContainer = true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public float evaluate(float x) {
        for(Function function : functions){
            function.evaluate(x);
        }
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void switchOn(float a, float b) {
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
        this.a = 0;
        this.b = 0;
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
