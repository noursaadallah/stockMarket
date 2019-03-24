package com.example.javaproject.model;

import javax.persistence.*;

@Entity
@Table(name = "investors")
public class Investor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int percent;
    private Boolean toSell;
    private Company company;

    public Investor() {
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}