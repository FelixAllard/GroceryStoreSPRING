package com.example.GroceryStoreApp.commons.identifiers;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import java.util.UUID;

@Embeddable
@Getter
public class PurchaseReceiptIdentifier {
    private String purchaseReceiptId;
    //Set the clientId to a UUID
    public PurchaseReceiptIdentifier() { this.purchaseReceiptId = UUID.randomUUID().toString(); }
    public PurchaseReceiptIdentifier(String purchaseReceiptId) { this.purchaseReceiptId = purchaseReceiptId; }
}
