package com.example.javaproject.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.javaproject.model.Investor;

public interface InvestorRepository extends CrudRepository<Investor, Integer> {
    Investor findByLogin(String login);
}