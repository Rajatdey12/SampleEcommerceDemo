package com.rajat.eCommerce.sampleApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajat.eCommerce.sampleApp.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
