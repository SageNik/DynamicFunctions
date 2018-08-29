package com.chisw.dynamicFunctions.entity.function;

import com.chisw.dynamicFunctions.entity.Calculation;
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
    public Calculation evaluate(Float x, String userName) {

        Float result = (float)(a * Math.cos(x + b));
        return new Calculation(this.getName(), userName, result, x);
    }
}
