package com.anke.Anke_Microservices_ShoppingCart_Service.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String shoppingCartName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShoppingCartName() {
        return shoppingCartName;
    }

    public void setShoppingCartName(String shoppingCartName) {
        this.shoppingCartName = shoppingCartName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @ManyToMany
    @JoinTable(name = "shopping_cart_product", joinColumns = @JoinColumn(name = "shopping_cart_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    Set<Product> products;
}
