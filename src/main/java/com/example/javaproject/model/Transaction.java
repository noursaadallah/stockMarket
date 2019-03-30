package com.example.javaproject.model;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private double value;
    private String companyName;
    private Integer companyId;
    private Integer shareId;
    private Integer buyerId;
    private Integer sellerId;
    
    public Transaction() {
    }

	public Transaction(double value, String companyName, Integer companyId, Integer shareId,
			Integer buyerId, Integer sellerId) {
		super();
		this.value = value;
		this.companyName = companyName;
		this.companyId = companyId;
		this.shareId = shareId;
		this.buyerId = buyerId;
		this.sellerId = sellerId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getShareId() {
		return shareId;
	}

	public void setShareId(Integer shareId) {
		this.shareId = shareId;
	}

	public Integer getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
    
}