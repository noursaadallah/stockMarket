package com.example.javaproject.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "investors")
public class Investor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String login;
    private String pwd;
    private String name;
    @OneToMany(cascade=CascadeType.ALL , mappedBy="investor")
    @JsonIgnore
    private List<Share> shares;
    private Boolean validated;

    public Investor() {
    	shares = new ArrayList<Share>();
    }

    public Investor(String login, String pwd, String name) {
		super();
		this.login = login;
		this.pwd = pwd;
		this.name = name;
		this.validated = false;
	}

	public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Share> getShares() {
		return shares;
	}


	public void setShares(List<Share> shares) {
		this.shares = shares;
	}


	public Boolean isValidated() {
		return validated;
	}


	public void setValidated(Boolean validated) {
		this.validated = validated;
	}
	
	public void buyShare(Share share, Investor investor) {
		share.setInvestor(this);
		share.setForSale(false);
		this.shares.add(share);
		investor.shares.remove(share);
	}
	
	public void setShareOffer(Share share , double price) {
		share.setForSale(true);
		share.setSellPrice(price);
	}
    
}