package com.example.javaproject.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.javaproject.model.Transaction;


public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
}