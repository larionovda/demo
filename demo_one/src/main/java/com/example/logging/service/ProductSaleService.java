package com.example.logging.service;

import com.example.logging.model.Products;
import com.example.logging.repository.ProductsRepository;
import com.example.logging.repository.SalesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductSaleService {

    private final ProductsRepository productsRepository;
    private final SalesRepository salesRepository;
    private final ProductSaleTransService productSaleTransService;

    @Transactional
    public void processTransaction() throws RuntimeException, IOException {

        List<Products> productsList = new ArrayList<>();

        productsList = productsRepository.findAll();

        var products = productsList.get(0);


        if (products.getInventory() < 600) {
            products.setInventory(products.getInventory() + 10);
        }

//        productsRepository.save(products);

//        try {
//           productSaleTransService.processTransaction(productsList);
//
//        } catch (PSQLException ex) {
//            productSaleTransService.processTransaction(productsList);
//        }

        productsList = productsRepository.findAll();

        productsList.size();

    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void processTransactionSecond() throws RuntimeException, IOException {
        List<Products> productsList = new ArrayList<>();

//        try {
            productSaleTransService.processTransactionSecond(productsList);

//        } catch (PSQLException ex) {
//            productSaleTransService.processTransaction(productsList);
//        }

    }
}
