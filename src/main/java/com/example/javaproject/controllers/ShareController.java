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
@RequestMapping("shares")
public class ShareController {
	
	private InvestorService investorService = new InvestorService();
	@Autowired
	private ShareRepository shareRepository;
	@Autowired
	private InvestorRepository investorRepository;
	@Autowired
	private TransactionRepository transactionRepository;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Share> getShares() {
		List<Share> shares = new ArrayList<Share>();
		Iterable<Share> _shares = shareRepository.findAll();
		_shares.forEach(shares::add);
		return shares;
	}
	
	@RequestMapping(value="/saleOffers" ,method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Share> saleOffers() {
		return shareRepository.findByForSale(true);
	}
	
	@RequestMapping(value="/buyShare/{buyerId}/{shareId}" ,method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void buyShare( @PathVariable("buyerId") Integer buyerId , @PathVariable("shareId") Integer shareId ) {
		if(investorRepository.existsById(buyerId) && shareRepository.existsById(shareId)) {
			Investor buyer = investorRepository.findById(buyerId).get();
			Share share = shareRepository.findById(shareId).get();
			if(share.getForSale()) {
				Transaction tx = investorService.buyShare(buyer, share);
				shareRepository.save(share);
				transactionRepository.save(tx);
			}
		}
	}
	
	@RequestMapping(value="/sellShare/{shareId}/{value}" ,method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void makeShareSaleOffer(@PathVariable("shareId") Integer shareId, @PathVariable("value") double value  ) {
		if(shareRepository.existsById(shareId)) {
			Share share = shareRepository.findById(shareId).get();
			shareRepository.save(share);
		}
	}
}
