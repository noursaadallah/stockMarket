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

    public Company(String name, double value, String sector, Manager manager, int sharesCount) {
		super();
		if(sharesCount <= 0)
			sharesCount=1;
		this.name = name;
		this.value = value;
		this.sector = sector;
		this.manager = manager;
		for(int i = 0 ; i < sharesCount ; i++)
			this.shares.add(new Share(100.0/sharesCount , value / sharesCount , this));
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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public List<Share> getShares() {
		return shares;
	}

	public void setShares(List<Share> shares) {
		this.shares = shares;
	}
	
}