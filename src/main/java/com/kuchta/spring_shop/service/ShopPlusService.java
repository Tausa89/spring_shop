package com.kuchta.spring_shop.service;

import com.kuchta.spring_shop.domain.product.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;


@Component
@Profile("Plus")
public class ShopPlusService extends ShopStartService {


    private List<Product> products;
    @Value("${vat-value}")
    private BigDecimal vat;

    public ShopPlusService() {
        this.products = init();
    }

    @Override
    public List<Product> init() {
        return super.init();
    }

    @Override
    public void addProduct(Product product) {
        super.addProduct(product);
    }

    @Override
    public BigDecimal countPrice() {

        return products
                .stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO,BigDecimal::add)
                .multiply(vat);
    }

    @EventListener(ApplicationReadyEvent.class)
    @Override
    public void showAllProductsPrice() {
        super.showAllProductsPrice();
    }

    @EventListener(ApplicationReadyEvent.class)
    @Override
    public void showAllProducts() {
        super.showAllProducts();
    }
}
