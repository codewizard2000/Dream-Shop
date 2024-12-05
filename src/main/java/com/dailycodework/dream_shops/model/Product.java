package com.dailycodework.dream_shops.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private String description;
    private BigDecimal price;
    private int inventory;
    // product and category is independent table onecs deleted than other will exist
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;// creating relationship
// single product can have many image
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true)//it means onces product is deleted all the image related to it will be deleted
    private List<Image> images;

    public Product(String name,String brand,BigDecimal price,int inventory,String description,Category category) {
        this.name = name;
        this.brand=brand;
        this.price=price;
        this.inventory=inventory;
        this.description=description;
        this.category=category;
    }
}
