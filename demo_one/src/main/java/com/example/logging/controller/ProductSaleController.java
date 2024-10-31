package com.example.logging.controller;

import com.example.logging.model.Products;
import com.example.logging.repository.ProductsRepository;
import com.example.logging.service.ProductSaleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ProductSaleController {

    private final ProductSaleService productSaleService;
    private final ProductsRepository productsRepository;


    @GetMapping("/products")
    public ResponseEntity<HttpStatus> getAllProducts() throws IOException {
        productSaleService.processTransaction();

        List<Products> productsList = new ArrayList<>();

        productsList = productsRepository.findAll();

        productsList.size();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/products/second")
    public ResponseEntity<HttpStatus> getAllProductsSecond() throws IOException {
        productSaleService.processTransactionSecond();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
