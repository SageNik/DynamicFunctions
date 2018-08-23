package com.chisw.dynamicFunctions.entity.function;

/**
 * This class is used for calculation Linear(a,b,x) function
 */
public class Linear extends PrimitiveFunction {

    /**
     * Constructor with all parameters
     */
    public Linear(String name) {
        super(name);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public float evaluate(float x) {

        return (a*x +b);
    }
}
