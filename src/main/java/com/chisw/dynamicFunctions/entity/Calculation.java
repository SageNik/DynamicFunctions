package com.chisw.dynamicFunctions.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Persistent Calculation entity with JPA markup.
 */
@Entity
@Table(name = "calculation")
@Data
public class Calculation implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "calculation_id_seq", sequenceName = "calculation_id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "calculation_id_seq")
    @Column(name = "id")
    private Long id;
    @Column(name = "function")
    @ManyToOne
    @JoinColumn
    private String function;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "result")
    private Float result;
    @Column(name = "x")
    private Float x;

    public Calculation(String function, String userName, Float result, Float x) {
        this.function = function;
        this.userName = userName;
        this.result = result;
        this.x = x;
    }
}
