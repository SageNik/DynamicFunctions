package com.chisw.dynamicFunctions.entity.function;

/**
 * This class is used for calculation Id(a,b,x) function
 */
public class Id extends PrimitiveFunction {

    /**
     * Constructor with all parameters
     */
    public Id(String name) {
        super(name);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public float evaluate(float x) {

        return x;
    }
}
