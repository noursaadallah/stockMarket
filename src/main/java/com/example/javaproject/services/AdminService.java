package com.example.javaproject.services;

import com.example.javaproject.model.Company;
import com.example.javaproject.model.Investor;
import com.example.javaproject.model.Manager;

public class AdminService {
    
	public int validateInvestorProfile(Investor investor) {
		if( investor == null ) return -1; // object not found
		if(investor.isValidated()) return 1; // object is found, but already validated
		investor.setValidated(true);
		return 0; // success
	}
	
	public Company createCompany(String name, double value, String sector, int sharesCount) {
		Company company = new Company(name, value, sector , sharesCount);
		company.createShares();
		return company;
	}
}
