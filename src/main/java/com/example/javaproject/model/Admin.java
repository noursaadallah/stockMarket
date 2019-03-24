package com.example.javaproject.model;

import javax.persistence.*;

@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String login;
    private String pwd;
    public Admin() {
    }

    public Admin(String login, String pwd) {
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

	@Override
    public String toString() {
        return "Admin{" +
                ", login='" + login + '\'' +
                ", pwd=" + pwd +
                '}';
    }
}