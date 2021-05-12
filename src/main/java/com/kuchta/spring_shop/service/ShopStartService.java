package com.kuchta.spring_shop.service;

import com.kuchta.spring_shop.config.ProductGenerator;
import com.kuchta.spring_shop.domain.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
@Profile("Start")
public class ShopStartService {


    private final List<Product> products;

    public ShopStartService() {
        this.products = init();
    }

    public List<Product> init() {
        var productGenerator = new ProductGenerator();
        return productGenerator.generateProducts();

    }

    public void addProduct(Product product) {

        products.add(product);
    }


    public BigDecimal countPrice() {

        return products
                .stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }


    @EventListener(ApplicationReadyEvent.class)
    public void showAllProductsPrice() {

        System.out.println("Total price of all products is " + countPrice());
    }

    @EventListener(ApplicationReadyEvent.class)
    public void  showAllProducts(){

        products.forEach(System.out::println);
    }


}
