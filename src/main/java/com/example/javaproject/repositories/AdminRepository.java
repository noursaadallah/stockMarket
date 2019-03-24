package com.example.javaproject.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.javaproject.model.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer> {
    Admin findByLogin(String login);
}