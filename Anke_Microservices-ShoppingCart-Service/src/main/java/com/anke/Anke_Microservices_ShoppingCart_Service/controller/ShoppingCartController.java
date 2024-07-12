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

        /*private ShoppingCartService shoppingCartService;

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
    }*/

    /*@Autowired
    ShoppingCartService shoppingCartService;

    @PostMapping("/create")
    public ResponseEntity<ShoppingCart> create(@RequestParam String name) {
        return shoppingCartService.create(name);
    }

    @PostMapping("/{shoppingCartId}/add-products")
    public ResponseEntity<ShoppingCart> addProducts(@PathVariable Long shoppingCartId, @RequestBody List<Product> products) {
        return shoppingCartService.addProducts(shoppingCartId, products);
    }*/

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
