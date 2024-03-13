package com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.presentationlayer;


import com.example.GroceryStoreApp.commons.enums.Currency;
import com.example.GroceryStoreApp.commons.enums.Price;
import com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.dataaccesslayer.Address;
import com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.dataaccesslayer.Contact;
import com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.dataaccesslayer.Membership;
import com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.dataaccesslayer.MembershipStatus;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequestModel {
    private String clientId;

    private String name;
    private String email;
    private String phone;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private double totalSpent;
    private int numberOfPoints;
    private String membershipStatus;
    private double value;
    private String currency;
}
