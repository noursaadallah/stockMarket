package com.example.javaproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.javaproject.model.User;
import com.example.javaproject.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Controller
@RequestMapping("users")
public class UserController {
	
    @Autowired
    private UserRepository userRepository;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		Iterable<User> _users = userRepository.findAll();
		_users.forEach(users::add);
		return users;
	}

	@RequestMapping(value="/{name}" ,method = RequestMethod.GET)
	//@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<User> getUserByName(@PathVariable("name")String name) {
		User user = userRepository.findByName(name);
		if(user == null)
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
}
