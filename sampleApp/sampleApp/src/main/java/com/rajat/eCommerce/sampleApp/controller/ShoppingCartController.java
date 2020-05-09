package com.rajat.eCommerce.sampleApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rajat.eCommerce.sampleApp.models.Product;
import com.rajat.eCommerce.sampleApp.models.ShoppingCart;
import com.rajat.eCommerce.sampleApp.repository.ProductRepository;
import com.rajat.eCommerce.sampleApp.repository.ShoppingCartRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartRepository shoppingcartRepository;
    
    @Autowired
    private ProductRepository productRepository;

    /*--
     *  Add Item in the Shopping Cart
     *   --*/

    @PostMapping(value = "/addItem")
    public List<ShoppingCart> addProductItem(@RequestBody final ShoppingCart shoppingCart) {
    	shoppingcartRepository.save(shoppingCart);
    	return shoppingcartRepository.findAll();
    }

    /*--
     *  Get All items of Shopping Cart
     *   --*/

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<ShoppingCart> getAll(){
        return shoppingcartRepository.findAll();
    }
    
    /*-- 
     * Get Cart Items by ID 
     * --*/
    
    @GetMapping(value = "/cartItems/{id}")
    public Optional<ShoppingCart> getCartItemsById(@PathVariable ("id") Long ids){
    	return shoppingcartRepository.findById(ids);
    
    }
    
    /*-- 
     * Update Cart Item By ID
     *  --*/
    
    @PutMapping(value = "/updateItem/{id}")
    public List<ShoppingCart> UpdateProductItem(@RequestBody ShoppingCart shoppingCart, @PathVariable("id") Long ids) {
    	shoppingcartRepository.save(shoppingCart);
    	return shoppingcartRepository.findAll();
    }
    
    /*-- 
     * Delete Cart Item By ID 
     * --*/

    @RequestMapping(method = RequestMethod.DELETE, value ="/delete/{id}")
    public List<ShoppingCart> deleteProductItem(@PathVariable("id") Long ids) {
        shoppingcartRepository.deleteById(ids);
        return shoppingcartRepository.findAll();
    }
    
    /*-- 
     * Delete All Cart Items at Once 
     * --*/

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteAll")
    public List<ShoppingCart> ClearCart() {
    	shoppingcartRepository.deleteAll();
    	return shoppingcartRepository.findAll();
    	
    }
    
    /*-- 
     * Purchase The Cart Item product/products
     *  --*/
    
    @PostMapping(value = "/purchase/{id}")
    public List<ShoppingCart> purchaseProducts(@RequestBody final ShoppingCart shoppingCart, @PathVariable("id") Long ids ,Product product) {
    	if(productRepository.findById(ids) != null) {
    	shoppingcartRepository.save(shoppingCart);
//    	productRepository.deleteById(ids);
    	}
		return shoppingcartRepository.findAll();
    }
}
