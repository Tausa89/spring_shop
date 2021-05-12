package com.kuchta.spring_shop.domain.product;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Product {


    private String name;
    private BigDecimal price;

}
