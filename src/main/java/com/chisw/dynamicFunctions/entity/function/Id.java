package com.chisw.dynamicFunctions.entity.function;

import com.chisw.dynamicFunctions.entity.Calculation;
import lombok.Data;

import javax.persistence.Entity;

/**
 * This class is used for calculation Id(a,b,x) function
 */
@Entity
@Data
public class Id extends PrimitiveFunction {

    /**
     * Constructor with all parameters
     */
    public Id(String name) {
        super(name);
    }
    public Id(){super();}

    /**
     *{@inheritDoc}
     */
    @Override
    public Calculation evaluate(Float x, String userName) {

        Float result = null;
        return new Calculation(this.getName(), userName, result, x);
    }
}
