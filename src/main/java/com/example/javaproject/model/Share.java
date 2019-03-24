package com.example.javaproject.model;

import javax.persistence.*;

@Entity
@Table(name = "shares")
public class Share {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private double percentage;
    @ManyToOne
    private Company company;
    @ManyToOne
    private Investor investor;
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