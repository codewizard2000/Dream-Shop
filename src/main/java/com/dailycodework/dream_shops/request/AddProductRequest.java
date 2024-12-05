package com.dailycodework.dream_shops.request;

import com.dailycodework.dream_shops.model.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddProductRequest {// it will be used in adding new product
    private Long id;
    private String name;
    private String brand;
    private String description;
    private BigDecimal price;
    private int inventory;
    private Category category;
}
