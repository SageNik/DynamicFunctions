package com.chisw.dynamicFunctions.entity.function;

/**
 * This class is used for calculation Const(a,b,x) function
 */
public class Const extends PrimitiveFunction {

    /**
     * Constructor with all parameters
     */
    public Const(String name) {
        super(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public float evaluate(float x) {
        return (a + b);
    }
}
