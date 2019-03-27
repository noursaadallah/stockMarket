package com.example.javaproject.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.javaproject.model.Manager;


public interface ManagerRepository extends CrudRepository<Manager, Integer> {
    Manager findByLogin(String login);
    List<Manager> findByName(String name);
    List<Manager> findByNameIgnoreCase(String name);
}