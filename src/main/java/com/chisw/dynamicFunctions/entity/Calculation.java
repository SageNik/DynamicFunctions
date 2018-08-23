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
    @Column(name = "function_name")
    private String functionName;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "result")
    private float result;
    @Column(name = "x")
    private float x;
}