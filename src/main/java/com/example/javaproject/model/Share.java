package com.example.javaproject.model;

import javax.persistence.*;

@Entity
@Table(name = "shares")
public class Share {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int percent;
    private Company company;
    private Investor owner;
    private Boolean forSale; // true if the share is currently for sale
    private double sellPrice;
    private double percentToSell; // the percentage of the sale if the owner does not sell all his shares
    
    public Share() {
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}