package com.example.logging.repository;

import com.example.logging.model.Sales;
import com.example.logging.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales, Integer> {
}
