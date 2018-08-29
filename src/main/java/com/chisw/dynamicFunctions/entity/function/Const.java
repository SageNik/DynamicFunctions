package com.chisw.dynamicFunctions.entity.function;

import com.chisw.dynamicFunctions.entity.Calculation;
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
    public Calculation evaluate(Float x, String userName) {
        Float result = (a + b);
        return new Calculation(this.getName(), userName, result, x);
    }
}
