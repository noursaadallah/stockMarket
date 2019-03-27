package com.example.javaproject.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    public Manager(String login, String pwd) {
    	this();
        this.login = login;
        this.pwd = pwd;
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
	}
	
	public void removeCompany(Company company) {
		this.companies.remove(company);
	}

	@Override
    public String toString() {
        return "Owner{" +
                ", login='" + login + '\'' +
                ", pwd=" + pwd +
                '}';
    }
}