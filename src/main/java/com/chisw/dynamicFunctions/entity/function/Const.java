package com.chisw.dynamicFunctions.entity.function;

import lombok.Data;

import javax.persistence.Entity;

/**
 * This class is used for calculation Const(a,b,x) function
 */
@Entity
@Data
public class Const extends PrimitiveFunction {

    /**
     * Constructor with all parameters
     */
    public Const(String name) {
        super(name);
    }
    public Const(){super();}

    /**
     * {@inheritDoc}
     */
    @Override
    public Float evaluate(Float x) {
        return (a + b);
    }
}
