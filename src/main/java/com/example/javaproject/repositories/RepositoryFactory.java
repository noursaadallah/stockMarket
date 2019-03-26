package com.example.javaproject.repositories;

import org.springframework.beans.factory.annotation.Autowired;

public class RepositoryFactory {
	
	private static RepositoryFactory repoFactory;
	
    @Autowired
    public InvestorRepository investorRepository;
    @Autowired
    public AdminRepository adminRepository;
    
    private RepositoryFactory() {
    }
    
    public static RepositoryFactory getRepoFactory() {
    	if(repoFactory == null) 
    		repoFactory = new RepositoryFactory();
    	return repoFactory;
    }
}
