package com.example.GroceryStoreApp.subdomains.employeesmanagementsubdomains.dataaccesslayer;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryArticle {
    private String name;
    private String description;
}
