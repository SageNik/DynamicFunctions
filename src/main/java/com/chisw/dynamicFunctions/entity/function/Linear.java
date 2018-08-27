package com.chisw.dynamicFunctions.entity.function;

import lombok.Data;

import javax.persistence.Entity;

/**
 * This class is used for calculation Linear(a,b,x) function
 */
@Entity
@Data
public class Linear extends PrimitiveFunction {

    /**
     * Constructor with all parameters
     */
    public Linear(String name) {
        super(name);
    }
    public Linear(){super();}

    /**
     *{@inheritDoc}
     */
    @Override
    public Float evaluate(Float x) {

        return (a*x +b);
    }
}
