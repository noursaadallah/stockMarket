package com.example.javaproject.utils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Credentials {

	public String login;
	public String pwd;
    
	@JsonCreator
    public Credentials(@JsonProperty("login") String login, 
    				@JsonProperty("pwd") String pwd) {
		super();
		this.login = login;
		this.pwd = pwd;
	}
}
