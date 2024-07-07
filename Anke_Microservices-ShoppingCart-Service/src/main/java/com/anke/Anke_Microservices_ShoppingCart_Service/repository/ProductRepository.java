package com.anke.Anke_Microservices_ShoppingCart_Service.repository;


import com.anke.Anke_Microservices_ShoppingCart_Service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<Product> findById(Long id);
}
