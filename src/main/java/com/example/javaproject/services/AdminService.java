package com.example.javaproject.services;

import com.example.javaproject.model.Investor;

public class AdminService {
    
	public int validateInvestorProfile(Investor investor) {
		if( investor == null ) return -1; // object not found
		if(investor.isValidated()) return 1; // object is found, but already validated
		investor.setValidated(true);
		return 0; // success
	}
}
