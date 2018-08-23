package com.chisw.dynamicFunctions.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Persistent Function entity with JPA markup.
 */
@Entity
@Table(name = "function")
@Data
@Inheritance (
        strategy=InheritanceType.SINGLE_TABLE)
public abstract class Function implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "function_id_seq", sequenceName = "function_id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "function_id_seq")
    @Column(name = "id")
    private Long id;
    /**
     * Name of function
     */
    private String name;
    /**
     * Arguments of function
     */
    protected float a,b,x;
    /**
     * It's field define can be used current function for calculation (available = true) or not (available = false)
     */
    protected boolean available;
    /**
     * It's field define have the current function defined arguments and ready to use (available = true) or not (available = false)
     */
    protected boolean switchedOn;
    /**
     * It's field define this instance is container and might have list of primitive functions (container = true) or not (container = false)
     */
    protected boolean asContainer;
    /**
     * It's field define container if this instance is primitive function and belong this container
     */
    @ManyToOne
    @JoinColumn()
    protected Function container;
    /**
     * List of primitive functions
     */
    @OneToMany(mappedBy = "container",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected List<Function> functions;

    public Function(String name) {
        this.name = name;
        this.available = true;
    }

    /**
     * This method for evaluating mathematical expression with argument x
     * @param x argument
     * @return float number as result of evaluation
     */
     public abstract float evaluate(float x);

    /**
     * This method switched on current function to evaluations and set params a and b. Set flag switchedOn = true
     * @param a parameter for evaluation
     * @param b parameter for evaluation
     */
    public abstract void switchOn(float a, float b);

    /**
     * This method switched off current function from evaluations and set params a and b as 0. Set flag switchedOn = false
     */
    public abstract void switchOff();



}
