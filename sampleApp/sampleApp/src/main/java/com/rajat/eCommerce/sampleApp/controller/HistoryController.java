package com.rajat.eCommerce.sampleApp.controller;
/*-- TO CHECK THE SHOPPING HISTORY --*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rajat.eCommerce.sampleApp.models.ShoppingCart;
import com.rajat.eCommerce.sampleApp.repository.ShoppingCartRepository;
import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private ShoppingCartRepository shoppingCartrepository;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<ShoppingCart> getAll(){
        return shoppingCartrepository.findAll();
    }


}