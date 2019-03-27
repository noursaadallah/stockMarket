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
	
	public Manager createManager(String login , String pwd) {
		return new Manager(login,pwd);
	}
	
	public void assignManagerToCompany(Manager manager, Company company) {
		manager.addCompany(company);
		company.setManager(manager);
	}
	
	public Company createCompany(String name, double value, String sector, Manager manager, int sharesCount) {
		return new Company(name, value, sector, manager, sharesCount);
	}
}
