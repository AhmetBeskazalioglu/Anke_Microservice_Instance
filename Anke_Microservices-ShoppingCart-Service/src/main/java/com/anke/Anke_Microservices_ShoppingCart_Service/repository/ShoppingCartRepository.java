package com.anke.Anke_Microservices_ShoppingCart_Service.repository;

import com.anke.Anke_Microservices_ShoppingCart_Service.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

}