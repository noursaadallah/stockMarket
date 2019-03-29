package com.example.javaproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.javaproject.model.Admin;
import com.example.javaproject.model.Company;
import com.example.javaproject.model.Investor;
import com.example.javaproject.model.Manager;
import com.example.javaproject.repositories.AdminRepository;
import com.example.javaproject.repositories.CompanyRepository;
import com.example.javaproject.repositories.InvestorRepository;
import com.example.javaproject.repositories.ManagerRepository;
import com.example.javaproject.repositories.RepositoryFactory;
import com.example.javaproject.services.AdminService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Controller
@RequestMapping("admins")
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private ManagerRepository managerRepository;
	@Autowired
	private InvestorRepository investorRepository;
	private AdminService adminService = new AdminService();

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Admin> getAdmins() {
		List<Admin> admins = new ArrayList<Admin>();
		Iterable<Admin> _admins = adminRepository.findAll();
		_admins.forEach(admins::add);
		return admins;
	}

	@RequestMapping(value="/{login}" ,method = RequestMethod.GET)
	//@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<Admin> getAdminByLogin(@PathVariable("login")String login) {
		Admin admin = adminRepository.findByLogin(login);
		if(admin == null)
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Admin>(admin,HttpStatus.OK);
	}
	
	@RequestMapping(value="/createManager" ,method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void createManager(@RequestBody Manager manager) {
		managerRepository.save(manager);
	}
	
	@RequestMapping(value="/createCompany/{managerLogin}" ,method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void createCompany(@RequestBody Company company , @PathVariable("managerLogin") String managerLogin) {
		Manager manager = managerRepository.findByLogin(managerLogin);
		manager.addCompany(company);
		company.createShares();
		managerRepository.save(manager);
	}
	
	@RequestMapping(value="/validateInvestor/{investorLogin}" ,method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void validateInvestor(@PathVariable("investorLogin") String investorLogin) {
		Investor investor = investorRepository.findByLogin(investorLogin);
		adminService.validateInvestorProfile(investor);
		investorRepository.save(investor);
	}
}
