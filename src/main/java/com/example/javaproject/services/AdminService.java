package com.example.javaproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.javaproject.model.Investor;
import com.example.javaproject.repositories.InvestorRepository;

public class AdminService {

    @Autowired
    private InvestorRepository investorRepository;
    
	public int validateInvestorProfile(int  investorId) {
		Optional<Investor> _investor = investorRepository.findById(investorId);
		if(!_investor.isPresent()) return -1; // object not found
		Investor investor = _investor.get();
		if(investor.isValidated()) return 1; // object is found, but already validated
		investor.setValidated(true);
		investorRepository.save(investor);
		return 0; // success
	}
}
