package com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.presentationlayer;


import com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.dataaccesslayer.Address;
import com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.dataaccesslayer.Contact;
import com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.dataaccesslayer.Membership;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequestModel {
    private String name;
    @Embedded
    private Contact contactInfo;
    @Embedded
    private Address address;
    @Embedded
    private Membership membership;
}
