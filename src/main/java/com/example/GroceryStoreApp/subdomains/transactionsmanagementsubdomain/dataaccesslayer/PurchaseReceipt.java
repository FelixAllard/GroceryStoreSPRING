package com.example.GroceryStoreApp.subdomains.transactionsmanagementsubdomain.dataaccesslayer;


import com.example.GroceryStoreApp.commons.enums.Price;
import com.example.GroceryStoreApp.commons.identifiers.PurchaseReceiptIdentifier;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "purchase_receipt")
@Data
@NoArgsConstructor
public class PurchaseReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private PurchaseReceiptIdentifier purchaseReceiptIdentifier;

    private double amount;
    @Embedded
    private CurrentDate currentDate;
    @Embedded
    private Price price;
    @Embedded
    private StoreAddress storeAddress;

    public PurchaseReceipt(
            CurrentDate currentDate,
            Price price,
            StoreAddress storeAddress
    ){
        this.currentDate = currentDate;
        this.price = price;
        this.storeAddress=storeAddress;
    }
}
