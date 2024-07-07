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

    @Autowired
    ShoppingCartService shoppingCartService;

    @PostMapping
    public ResponseEntity<ShoppingCart> createCart(@RequestParam("name") String name) {
        return shoppingCartService.createCart(name);
    }

    @PostMapping("{id}")
    public ResponseEntity<ShoppingCart> addProductsToCart(@PathVariable("id") Long shoppingCartId,
                                                          @RequestBody List<Product> products) {

        return shoppingCartService.addProducts(shoppingCartId, products);

    }

    @DeleteMapping("/{id}/products/{productId}")
    public ResponseEntity<ShoppingCart> removeProduct(@PathVariable("id") Long shoppingCartId,
                                                      @PathVariable("productId") Long productId) {
        return shoppingCartService.removeProduct(shoppingCartId, productId);
    }

    @GetMapping("/totalprice/{id}")
    public ResponseEntity<Map<String, String>> getTotalPrice(@PathVariable("id") Long shoppingCartId) {
        return shoppingCartService.getShoppingCartPrice(shoppingCartId);
    }

    @GetMapping("{id}")
    public ResponseEntity<ShoppingCart> getCartById(@PathVariable("id") Long shoppingCartId) {
        return shoppingCartService.getCartById(shoppingCartId);
    }

    @GetMapping("/by-name/{name}")
    public ResponseEntity<ShoppingCart> getCartByShoppingCartName(@PathVariable("name") String shoppingCartName) {
        return shoppingCartService.getCartByShoppingCartName(shoppingCartName);
    }

    @GetMapping
    public ResponseEntity<List<ShoppingCart>> getAllCarts() {
        return shoppingCartService.getAllCarts();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCartById(@PathVariable("id") Long shoppingCartId) {
        return shoppingCartService.deleteCartById(shoppingCartId);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllCarts() {
        return shoppingCartService.deleteAllCarts();
    }
}
