package com.chisw.dynamicFunctions.entity.function;

/**
 * This class is used for calculation Cos(a,b,x) function
 */
public class Cos extends PrimitiveFunction {

    /**
     * Constructor with all parameters
     */
    public Cos(String name) {
        super(name);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public float evaluate(float x) {

        return (float)(a*Math.cos(x+b));
    }
}
