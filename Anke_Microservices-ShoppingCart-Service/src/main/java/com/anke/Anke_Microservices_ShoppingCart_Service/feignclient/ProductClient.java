package com.anke.Anke_Microservices_ShoppingCart_Service.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface ProductClient {

    @GetMapping("/api/product/{productId}")
    Product getProductById(@PathVariable("productId") Long productId);

}
