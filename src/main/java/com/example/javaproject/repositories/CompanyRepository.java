package com.example.javaproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.javaproject.model.Admin;
import com.example.javaproject.model.Company;


public interface CompanyRepository extends CrudRepository<Company, Integer> {
    Company findByName(String name);
    List<Company> findBySector(String sector);
}