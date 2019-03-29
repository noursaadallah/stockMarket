package com.example.javaproject.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "managers")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String login;
    private String pwd;
    private String name;
    @OneToMany(cascade=CascadeType.ALL , mappedBy="manager")
    @JsonIgnore
    private List<Company> companies;
    
    public Manager() {
    	companies = new ArrayList<Company>();
    }

	@JsonCreator
	public Manager( @JsonProperty("login") String login, 
					@JsonProperty("pwd") String pwd,
					@JsonProperty("name") String name ) {
		this();
        this.login = login;
        this.pwd = pwd;
        this.name = name;
	}

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}
	
	public void addCompany(Company company) {
		this.companies.add(company);
		company.setManager(this);
	}
	
	public void removeCompany(Company company) {
		this.companies.remove(company);
		company.setManager(null);
	}

	@Override
    public String toString() {
        return "Owner{" +
                ", login='" + login + '\'' +
                ", pwd=" + pwd +
                '}';
    }
}