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

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Controller
@RequestMapping("investors")
public class InvestorController {
	
	@Autowired
	private InvestorRepository investorRepository;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Investor> getInvestors() {
		List<Investor> investors = new ArrayList<Investor>();
		Iterable<Investor> _investors = investorRepository.findAll();
		_investors.forEach(investors::add);
		return investors;
	}

	@RequestMapping(value="/{login}" ,method = RequestMethod.GET)
	//@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<Investor> getInvestorByLogin(@PathVariable("login")String login) {
		Investor investor = investorRepository.findByLogin(login);
		if(investor == null)
			return new ResponseEntity<Investor>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Investor>(investor,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findByName/{name}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Investor> findByName(@PathVariable("name")String name) {
		return investorRepository.findByName(name);
	}
	
	@RequestMapping(value = "/findByValidated/{validated}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Investor> findByValidated(@PathVariable("validated")boolean validated) {
		return investorRepository.findByValidated(validated);
	}
	
	@RequestMapping(value = "/findByValidated-Name/{name}/{validated}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Investor> findByNameValidated(@PathVariable("name")String name,@PathVariable("validated")boolean validated) {
		return investorRepository.findByNameAndValidated(name,validated);
	}
	
	@RequestMapping(value="/signup" ,method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void signup(@RequestBody Investor investor) {
		investorRepository.save(investor);
	}
}
