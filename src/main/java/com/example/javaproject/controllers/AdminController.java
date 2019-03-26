package com.example.javaproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.javaproject.model.Admin;
import com.example.javaproject.repositories.AdminRepository;
import com.example.javaproject.repositories.InvestorRepository;
import com.example.javaproject.repositories.RepositoryFactory;

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
}
