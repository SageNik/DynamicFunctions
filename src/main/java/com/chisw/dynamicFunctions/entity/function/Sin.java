package com.chisw.dynamicFunctions.entity.function;

/**
 * This class is used for calculation Sin(a,b,x) function
 */
public class Sin extends PrimitiveFunction {

    /**
     * Constructor with all parameters
     */
    public Sin(String name) {
        super(name);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public float evaluate(float x) {
        return (float)(a*Math.sin(x+b));
    }
}
