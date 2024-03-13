package com.example.GroceryStoreApp.subdomains.productsmanagementsubdomain.dataaccesslayer;

import com.example.GroceryStoreApp.commons.enums.Price;
import com.example.GroceryStoreApp.commons.enums.ProductAvailability;
import com.example.GroceryStoreApp.commons.identifiers.ProductIdentifier;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;

    @Embedded
    private PalletImportedFrom palletImportedFrom;

    @Enumerated(EnumType.STRING)
    private ProductAvailability productAvailability;

    @Embedded
    private Price price;

    @Embedded
    private CategoryArticle categoryArticle;

    @Embedded
    private Image image;

    @Embedded
    private ProductIdentifier productIdentifier;

    public Product(
            @NotNull PalletImportedFrom palletImportedFrom,
            @NotNull Price price,
            @NotNull CategoryArticle categoryArticle,
            @NotNull Image image,
            @NotNull ProductIdentifier productIdentifier
            ){
        this.palletImportedFrom = palletImportedFrom;
        this.price = price;
        this.categoryArticle = categoryArticle;
        this.image = image;
        this.productIdentifier = productIdentifier;
    }
}
