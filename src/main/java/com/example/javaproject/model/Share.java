package com.example.javaproject.model;

import javax.persistence.*;

@Entity
@Table(name = "shares")
public class Share {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private double percentage;
    private double value;
    @ManyToOne
    private Company company;
    @ManyToOne
    private Investor investor;
    private Boolean forSale; // true if the share is currently for sale
    private double sellPrice;
    
    public Share() {
    }
   
    public Share(double percentage, double value) {
		super();
		this.percentage = percentage;
		this.value = value;
		this.forSale = true;
	}


	public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


	public double getPercentage() {
		return percentage;
	}


	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}


	public double getValue() {
		return value;
	}


	public void setValue(double value) {
		this.value = value;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public Investor getInvestor() {
		return investor;
	}


	public void setInvestor(Investor investor) {
		this.investor = investor;
	}


	public Boolean getForSale() {
		return forSale;
	}


	public void setForSale(Boolean forSale) {
		this.forSale = forSale;
	}


	public double getSellPrice() {
		return sellPrice;
	}


	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
    
}