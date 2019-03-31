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
import com.example.javaproject.model.Transaction;
import com.example.javaproject.model.Investor;
import com.example.javaproject.model.Manager;
import com.example.javaproject.model.Share;
import com.example.javaproject.model.Transaction;
import com.example.javaproject.repositories.AdminRepository;
import com.example.javaproject.repositories.TransactionRepository;
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
@RequestMapping("transactions")
public class TransactionController {
	
	@Autowired
	private TransactionRepository transactionRepository;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Transaction> getTransactions() {
		List<Transaction> transactions = new ArrayList<Transaction>();
		Iterable<Transaction> _transactions= transactionRepository.findAll();
		_transactions.forEach(transactions::add);
		return transactions;
	}
	
	@RequestMapping(value="/byCompanyName/{companyName}" ,method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Transaction> findByCompanyName(@PathVariable("companyName") String name) {
		return transactionRepository.findByCompanyName(name);
	}
	
	@RequestMapping(value="/byCompanyId/{companyId}" ,method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Transaction> findByCompanyId(@PathVariable("companyId") Integer companyId) {
		return transactionRepository.findByCompanyId(companyId);
	}
	
	@RequestMapping(value="/byShareId/{shareId}" ,method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Transaction> findByShareId(@PathVariable("shareId") Integer shareId) {
		return transactionRepository.findByShareId(shareId);
	}
	
	@RequestMapping(value="/byInvestorId/{investorId}" ,method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Transaction> findByInvestorId(@PathVariable("investorId") Integer investorId) {
		return transactionRepository.findDistinctByBuyerIdOrSellerId(investorId, investorId);
	}
	
}
