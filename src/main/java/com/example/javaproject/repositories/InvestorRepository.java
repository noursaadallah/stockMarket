package com.example.javaproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.javaproject.model.Investor;


public interface InvestorRepository extends CrudRepository<Investor, Integer> {
    Investor findByLogin(String login);
    List<Investor> findByName(String name);
    List<Investor> findByNameIgnoreCase(String name);
    List<Investor> findByValidated(Boolean validated);
    List<Investor> findByNameAndValidated(String name, Boolean validated);
}