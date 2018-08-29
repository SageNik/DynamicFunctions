package com.chisw.dynamicFunctions.entity.function;

import com.chisw.dynamicFunctions.entity.Calculation;
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
    public Calculation evaluate(Float x, String userName) {

        Float result = (a*x +b);
        return new Calculation(this.getName(), userName, result, x);
    }
}
