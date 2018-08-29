package com.chisw.dynamicFunctions.entity.function;

import com.chisw.dynamicFunctions.entity.Calculation;
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
    public Calculation evaluate(Float x, String userName) {

        Float result = (float)(a*Math.sin(x+b));
        return new Calculation(this.getName(), userName, result, x);
    }
}
