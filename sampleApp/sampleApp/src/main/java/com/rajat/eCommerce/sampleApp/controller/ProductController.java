package com.rajat.eCommerce.sampleApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rajat.eCommerce.sampleApp.models.Product;
import com.rajat.eCommerce.sampleApp.repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Product> getAll(){
        return productRepository.findAll();
    }
    
    @PostMapping(value = "/addProducts")
    public List<Product> addProds(@RequestBody final Product product){
    	productRepository.save(product);
    	return productRepository.findAll();
    }
}