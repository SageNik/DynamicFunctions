package com.chisw.dynamicFunctions.entity.function;

import lombok.Data;

import javax.persistence.Entity;

/**
 * This class is used for calculation Sin(a,b,x) function
 */
@Entity
@Data
public class Sin extends PrimitiveFunction {

    /**
     * Constructor with all parameters
     */
    public Sin(String name) {
        super(name);
    }
    public Sin(){ super();}
    /**
     *{@inheritDoc}
     */
    @Override
    public Float evaluate(Float x) {
        return (float)(a*Math.sin(x+b));
    }
}
