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
import com.example.javaproject.model.Share;
import com.example.javaproject.model.Transaction;
import com.example.javaproject.repositories.AdminRepository;
import com.example.javaproject.repositories.CompanyRepository;
import com.example.javaproject.repositories.InvestorRepository;
import com.example.javaproject.repositories.ManagerRepository;
import com.example.javaproject.repositories.RepositoryFactory;
import com.example.javaproject.repositories.ShareRepository;
import com.example.javaproject.repositories.TransactionRepository;
import com.example.javaproject.services.InvestorService;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Controller
@RequestMapping("companies")
public class CompanyController {
	
	@Autowired
	private CompanyRepository companyRepository;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Company> getCompanies() {
		List<Company> companies = new ArrayList<Company>();
		Iterable<Company> _companies= companyRepository.findAll();
		_companies.forEach(companies::add);
		return companies;
	}
	
	@RequestMapping(value="/{name}" ,method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Company findByName(@PathVariable("name") String name) {
		return companyRepository.findByName(name);
	}
	
	@RequestMapping(value="/bySector/{sector}" ,method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Company> findBySector(@PathVariable("sector") String sector) {
		return companyRepository.findBySector(sector);
	}
	
}
