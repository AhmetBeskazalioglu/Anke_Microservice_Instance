package com.anke.Anke_Microservices_ShoppingCart_Service.service;

import com.anke.Anke_Microservices_ShoppingCart_Service.entity.Product;
import com.anke.Anke_Microservices_ShoppingCart_Service.entity.ShoppingCart;
import com.anke.Anke_Microservices_ShoppingCart_Service.feignclient.ProductClient;
import com.anke.Anke_Microservices_ShoppingCart_Service.repository.ProductRepository;
import com.anke.Anke_Microservices_ShoppingCart_Service.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class ShoppingCartService {

    /*@Autowired
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
*/

    @Autowired ShoppingCartRepository shoppingCartRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity<ShoppingCart> create(String name) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setShoppincartName(name);
        return ResponseEntity.ok().body(shoppingCartRepository.save(shoppingCart));
    }

    public ResponseEntity<ShoppingCart> addProducts(Long shoppingCartId, List<Product> products) {
        ShoppingCart shoppingCart =
                shoppingCartRepository
                        .findById(shoppingCartId)
                        .orElseThrow(() -> new RuntimeException("Verilen id ile eşleşen bir sonuç bulunamadı"));

        products.forEach(product -> productRepository.saveAndFlush(product));

        Set<Product> newProducts = new HashSet<>(products);
        shoppingCart.setProducts(newProducts);
        return ResponseEntity.ok().body(shoppingCartRepository.save(shoppingCart));
    }

    public ResponseEntity<Map<String, String>> getShoppingCartPrice(Long shoppingCartId) {
        Map<String, String> response = new HashMap<>();

        ShoppingCart shoppingCart = shoppingCartRepository.findById(shoppingCartId)
                .orElseThrow(() -> new RuntimeException("Shopping cart not found"));

        int totalPrice = shoppingCart
                .getProducts().stream().map(product -> restTemplate
                        .getForObject("http://localhost:8764/api/product/" + product.getId(), HashMap.class))
                .mapToInt(productResponse -> (int) productResponse.get("price")).sum();
        response.put("total_price", Double.toString(totalPrice));

        return ResponseEntity.ok().body(response);
    }


}
