package com.rajat.eCommerce.sampleApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rajat.eCommerce.sampleApp.models.Product;
import com.rajat.eCommerce.sampleApp.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    /*--
     * Get All Products 
     *--*/
    
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Product> getAll(){
        return productRepository.findAll();
    }
    
    /*--
     * Get Product By ID 
     * --*/
    
    @GetMapping(value = "/getProduct/{id}")
    public Optional<Product> getProductById(@PathVariable ("id") Long ids){
    	return productRepository.findById(ids);
    }
    
    /*-- 
     * Add Products 
     * --*/
    
    @PostMapping(value = "/addProducts")
    public List<Product> addProds(@RequestBody final Product product){
    	productRepository.save(product);
    	return productRepository.findAll();
    }
   
    /*--
     * Delete All Product
     * --*/
    
    @DeleteMapping(value = "/deleteAllProduct")
    public List<Product> deleteAllProduct(){
    	productRepository.deleteAll();
    	return productRepository.findAll();
    }
    
    /*--
     * Deleting Product By ID 
     * --*/
    
    @DeleteMapping(value = "/deleteProduct/{id}")
    public List<Product> deleteProductById(@PathVariable ("id") Long id){
    	productRepository.deleteById(id);
    	return productRepository.findAll();
    }
}