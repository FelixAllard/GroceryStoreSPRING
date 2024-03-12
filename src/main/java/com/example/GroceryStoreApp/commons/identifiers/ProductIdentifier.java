package com.example.GroceryStoreApp.commons.identifiers;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import java.util.UUID;

@Embeddable
@Getter
public class ProductIdentifier {
    private String productId;
    //Set the clientId to a UUID
    public ProductIdentifier() { this.productId = UUID.randomUUID().toString(); }
    public ProductIdentifier(String employeeId) { this.productId = employeeId; }
}
