package com.example.javaproject.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.javaproject.model.Company;
import com.example.javaproject.model.Investor;
import com.example.javaproject.model.Manager;
import com.example.javaproject.model.Share;
import com.example.javaproject.model.Transaction;
import com.example.javaproject.repositories.CompanyRepository;
import com.example.javaproject.repositories.InvestorRepository;
import com.example.javaproject.repositories.ManagerRepository;
import com.example.javaproject.repositories.ShareRepository;
import com.example.javaproject.repositories.TransactionRepository;

import static org.junit.Assert.*;

import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class InvestorServiceTest {
    
    private InvestorService investorService = new InvestorService();
    
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private InvestorRepository investorRepository;
    @Autowired
    private ShareRepository shareRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CompanyRepository companyRepository;
    
    @Before
    public void setup() {
//    	Manager manager = managerRepository.findByLogin("test");
//    	Company company = companyRepository.findByName("test");
//    	Investor investor = investorRepository.findByLogin("test");
//    	managerRepository.delete(manager);
//    	companyRepository.delete(company);
//    	investorRepository.delete(investor);
    }
    
    @Test
    public void testShareServices(){
    	//============================== Test creation ===============================================\\
    	Manager manager = new Manager("test" , "test" , "test");
    	Company company = new Company("test" , 1000 , "test" , 1);
    	company.createShares();
    	manager.addCompany(company);
    	managerRepository.save(manager); // saves manager, company and share because of cascade
    	assertNotNull(manager.getId());
    	assertNotNull(company.getId());
    	assertNotNull(company.getManager());
    	assertNotNull(company.getShares());
    	assertNotEquals(0 , company.getShares().size());
    	Share share = company.getShares().get(0);
    	assertNotNull(share.getId());
    	
    	Investor investor = new Investor("test", "test", "test");
    	investorRepository.save(investor);
    	assertNotNull(investor.getId());
    	
    	//============================== Test buy share ===============================================\\
    	Transaction tx = investorService.buyShare(investor, share);
    	shareRepository.save(share); // propagate edit to the share
    	assertNotNull(share.getInvestor());
    	transactionRepository.save(tx);
    	assertNotNull(tx.getId());
    	
    	//============================== Test make share sale offer ===============================================\\
    	investorService.makeShareSaleOffer(share, 500);
    	shareRepository.save(share);
    	assertEquals(500, share.getSellPrice() , 0.001);
    	assertEquals(true, share.getForSale());
    	
    }
}