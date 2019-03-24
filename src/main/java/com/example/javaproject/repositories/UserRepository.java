package com.example.javaproject.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.javaproject.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByName(String name);
}