package com.example.logging.repository;

import com.example.logging.model.Products;
import com.example.logging.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
}
