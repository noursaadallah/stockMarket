package com.example.javaproject.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.javaproject.model.Admin;
import com.example.javaproject.model.Investor;
import com.example.javaproject.repositories.InvestorRepository;
import com.example.javaproject.repositories.RepositoryFactory;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {
    
    private AdminService adminService = new AdminService();
    
    @Autowired
    private InvestorRepository investorRepository;
    
    @Test
    public void testValidateInvestor(){

    	Investor investor = new Investor("investor" , "investor");
//      //save investor, verify has ID value after save
        assertNull(investor.getId());//null before save
        investorRepository.save(investor);
        assertNotNull(investor.getId());
        int id = investor.getId();
        investor = investorRepository.findByLogin("investor");
        assertNotNull(investor);
        assertEquals(false, investor.isValidated());
        
        int res = adminService.validateInvestorProfile(investor);
        investorRepository.save(investor);
        assertEquals(true, investor.isValidated());
    }
}