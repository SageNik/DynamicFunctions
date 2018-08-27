package com.chisw.dynamicFunctions.entity.function;

import lombok.Data;

import javax.persistence.Entity;

/**
 * This class is used for calculation Cos(a,b,x) function
 */
@Entity
@Data
public class Cos extends PrimitiveFunction {

    /**
     * Constructor with all parameters
     */
    public Cos(String name) {
        super(name);
    }
    public Cos(){super();}

    /**
     *{@inheritDoc}
     */
    @Override
    public Float evaluate(Float x) {

        return (float) (a * Math.cos(x + b));
    }
}
