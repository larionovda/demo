package com.example.logging.service;

import com.example.logging.model.Products;
import com.example.logging.repository.ProductsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductSaleTransService {

    private final ProductsRepository productsRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void processTransaction(List<Products> productsList)  {
        productsList = productsRepository.findAll();

        var products = productsList.get(0);


        if (products.getInventory() < 600) {
            products.setInventory(products.getInventory() + 10);
        }

        productsRepository.save(products);


//        throw new RuntimeException();
    }

//    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void processTransactionSecond(List<Products> productsList) {
        productsList = productsRepository.findAll();
        var products = productsList.get(0);
        products.setInventory(products.getInventory() + 10);
        productsRepository.save(products);

    }

}
