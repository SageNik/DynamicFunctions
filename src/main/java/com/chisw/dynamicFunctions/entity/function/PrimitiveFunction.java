package com.chisw.dynamicFunctions.entity.function;

import com.chisw.dynamicFunctions.entity.Function;
import com.chisw.dynamicFunctions.exception.FunctionNotFoundException;

/**
 * Abstract class for base entity for different functions.
 */
public abstract class PrimitiveFunction extends Function {

    public PrimitiveFunction(String name) {
        super(name);
    }

    public static PrimitiveFunction getFunction(String functionName) throws FunctionNotFoundException{

            switch (functionName){
                case "Const": return new Const(functionName);
                case "Linear": return new Linear(functionName);
                case "Sin": return new Sin(functionName);
                case "Cos": return new Cos(functionName);
                case "Id": return new Id(functionName);
                default: throw new FunctionNotFoundException(functionName);
            }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void switchOn(float a, float b) {
        this.setA(a);
        this.setB(b);
        this.setSwitchedOn(true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void switchOff() {
        this.setA(0);
        this.setB(0);
        this.setSwitchedOn(false);
    }

}
