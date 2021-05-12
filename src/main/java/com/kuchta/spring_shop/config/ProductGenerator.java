package com.kuchta.spring_shop.config;

import com.github.javafaker.Faker;
import com.kuchta.spring_shop.domain.product.Product;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class ProductGenerator {

    private final Faker faker = new Faker();


    public List<Product> generateProducts(){

        return IntStream.range(0,5)
                .mapToObj(index -> generateProduct())
                .collect(Collectors.toList());

    }

    private Product generateProduct(){

        return Product
                .builder()
                .name(faker.food().ingredient())
                .price(BigDecimal.valueOf(faker.number().numberBetween(50L,300L)))
                .build();

    }
}
