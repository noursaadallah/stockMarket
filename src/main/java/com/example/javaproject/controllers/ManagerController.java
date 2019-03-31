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
import com.example.javaproject.model.Manager;
import com.example.javaproject.model.Investor;
import com.example.javaproject.model.Manager;
import com.example.javaproject.model.Share;
import com.example.javaproject.model.Transaction;
import com.example.javaproject.repositories.AdminRepository;
import com.example.javaproject.repositories.ManagerRepository;
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
@RequestMapping("managers")
public class ManagerController {
	
	@Autowired
	private ManagerRepository managerRepository;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Manager> getManagers() {
		List<Manager> companies = new ArrayList<Manager>();
		Iterable<Manager> _companies= managerRepository.findAll();
		_companies.forEach(companies::add);
		return companies;
	}
	
	@RequestMapping(value="/{login}" ,method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Manager findByLogin(@PathVariable("login") String login) {
		return managerRepository.findByLogin(login);
	}
	
	@RequestMapping(value="/byName/{name}" ,method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Manager> findByName(@PathVariable("name") String name) {
		return managerRepository.findByName(name);
	}
	
}
