package com.rajat.eCommerce.sampleApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rajat.eCommerce.sampleApp.models.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

}
