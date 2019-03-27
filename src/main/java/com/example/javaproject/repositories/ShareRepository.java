package com.example.javaproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.javaproject.model.Share;


public interface ShareRepository extends CrudRepository<Share, Integer> {
    List<Share> findByForSale(Boolean forSale);
}