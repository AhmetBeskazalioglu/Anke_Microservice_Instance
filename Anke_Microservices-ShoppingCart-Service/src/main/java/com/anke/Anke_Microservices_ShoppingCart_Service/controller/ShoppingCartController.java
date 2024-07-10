package com.anke.Anke_Microservices_ShoppingCart_Service.controller;

import com.anke.Anke_Microservices_ShoppingCart_Service.entity.ShoppingCart;
import com.anke.Anke_Microservices_ShoppingCart_Service.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/shopping-cart")
public class ShoppingCartController {

        private ShoppingCartService shoppingCartService;

        @Autowired
        public ShoppingCartController(ShoppingCartService shoppingCartService) {
                this.shoppingCartService = shoppingCartService;
        }

    @PostMapping("/add")
    public ResponseEntity<String> addProductToCart(@RequestParam Long productId) {
        shoppingCartService.addProductToCart(productId);
        return ResponseEntity.ok("Product added to cart successfully");
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<ShoppingCart> getCartById(@PathVariable Long cartId) {
        return ResponseEntity.ok(shoppingCartService.getCartById(cartId));
    }
}
