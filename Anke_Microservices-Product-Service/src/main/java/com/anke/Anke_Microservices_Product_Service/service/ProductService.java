package com.anke.Anke_Microservices_Product_Service.service;

import com.anke.Anke_Microservices_Product_Service.entity.Product;
import com.anke.Anke_Microservices_Product_Service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {


    @Autowired
    ProductRepository productRepository;

    //database deki eklenen kayıt satırı nesneye dönüştürülüp bu metodu kim nerde
    //çağırıyorsa ona json olarak döner  {"name":"urun"}
    public Product createProduct(Product product) {
        //jdbc insert into product (name,price,description) values(product.name,product.price);
        return productRepository.save(product);
    }

}
