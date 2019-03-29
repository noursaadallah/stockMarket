package com.example.javaproject.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private double value;
    private String sector;
    private int sharesCount;
    @ManyToOne
    private Manager manager;
    @OneToMany(cascade=CascadeType.ALL , mappedBy="company")
    @JsonIgnore
    private List<Share> shares;
    
    public Company() {
    	this.shares = new ArrayList<Share>();
    }

    @JsonCreator
    public Company(@JsonProperty("name") String name, 
    				@JsonProperty("value") double value, 
    				@JsonProperty("sector") String sector,
    				@JsonProperty("sharesCount") int sharesCount) {
		super();
		this.name = name;
		this.value = value;
		this.sector = sector;
		this.sharesCount = sharesCount;
	}
    
    public void createShares() {
    	this.shares = new ArrayList<Share>(sharesCount);
		if(this.sharesCount <= 0)
			this.sharesCount=1;
		for(int i = 0 ; i < this.sharesCount ; i++)
			this.shares.add(new Share(100.0/this.sharesCount , value / this.sharesCount));
		for(Share s : this.shares) {
			s.setCompany(this);
		}
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