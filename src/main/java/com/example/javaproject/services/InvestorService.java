package com.example.javaproject.services;

import com.example.javaproject.model.Investor;
import com.example.javaproject.model.Share;
import com.example.javaproject.model.Transaction;

public class InvestorService {
	
	public Transaction buyShare(Investor buyer, Share share) {
		share.setInvestor(buyer); // the buyer becomes the owner of the share
		share.setForSale(false);
		share.setSellPrice(0);
		Transaction tx;
		if(share.getInvestor() != null)
			tx = new Transaction(share.getSellPrice(), share.getCompany().getName(),
					share.getCompany().getId() , share.getId() , buyer.getId() , share.getInvestor().getId());
		else
			tx = new Transaction(share.getSellPrice(), share.getCompany().getName(),
					share.getCompany().getId() , share.getId() , buyer.getId() , -1);
		return tx;
	}
	
	public void makeShareSaleOffer(Share share , double price) {
		share.setForSale(true);
		share.setSellPrice(price);
	}
}
