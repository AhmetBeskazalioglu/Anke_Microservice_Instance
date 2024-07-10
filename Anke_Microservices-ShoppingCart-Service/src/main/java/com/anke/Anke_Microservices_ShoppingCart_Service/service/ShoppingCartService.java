package com.anke.Anke_Microservices_ShoppingCart_Service.service;

import com.anke.Anke_Microservices_ShoppingCart_Service.feignclient.Product;
import com.anke.Anke_Microservices_ShoppingCart_Service.entity.ShoppingCart;
import com.anke.Anke_Microservices_ShoppingCart_Service.feignclient.ProductClient;
import com.anke.Anke_Microservices_ShoppingCart_Service.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {

    @Autowired
    private ProductClient productClient;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public ResponseEntity<String> addProductToCart(Long productId) {

        // Get product by id
        Product product = productClient.getProductById(productId);

        // Add product to cart
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setProductId(product.getId());
        shoppingCart.setProductName(product.getName());
        shoppingCart.setProductPrice(product.getPrice());
        shoppingCartRepository.save(shoppingCart);

        return ResponseEntity.ok("Product added to cart successfully");
    }

    public ShoppingCart getCartById(Long cartId) {
        return shoppingCartRepository.findById(cartId).orElse(null);
    }
}
