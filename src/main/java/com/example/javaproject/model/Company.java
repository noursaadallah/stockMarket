package com.example.javaproject.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private double value;
    private String sector;
    @ManyToOne
    private Manager manager;
    @OneToMany(cascade=CascadeType.ALL , mappedBy="company")
    @JsonIgnore
    private List<Share> shares;
    
    public Company() {
    	shares = new ArrayList<Share>();
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
		return name;
	}

	public void setName(String login) {
		this.name = login;
	}
}