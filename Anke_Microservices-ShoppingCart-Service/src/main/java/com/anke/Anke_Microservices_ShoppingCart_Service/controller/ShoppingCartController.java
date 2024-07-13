package com.anke.Anke_Microservices_ShoppingCart_Service.controller;

import com.anke.Anke_Microservices_ShoppingCart_Service.entity.Product;
import com.anke.Anke_Microservices_ShoppingCart_Service.entity.ShoppingCart;
import com.anke.Anke_Microservices_ShoppingCart_Service.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/shopping-cart")
public class ShoppingCartController {

    @Autowired ShoppingCartService shoppingCartService;

    @PostMapping
    public ResponseEntity<ShoppingCart> create(@RequestParam("name") String name) {
        return shoppingCartService.create(name);
    }

    @PostMapping("{id}")
    public ResponseEntity<ShoppingCart> addProducts(
            @PathVariable("id") Long shoppingCartId, @RequestBody List<Product> products) {
        return shoppingCartService.addProducts(shoppingCartId, products);
    }

    @GetMapping("{id}")
    public ResponseEntity<Map<String, String>> getShoppingCartPrice(
            @PathVariable("id") Long shoppingCartId) {
        return shoppingCartService.getShoppingCartPrice(shoppingCartId);
    }
}
