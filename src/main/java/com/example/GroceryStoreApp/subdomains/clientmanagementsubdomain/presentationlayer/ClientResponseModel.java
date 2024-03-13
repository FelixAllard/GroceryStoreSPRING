package com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.presentationlayer;

import com.example.GroceryStoreApp.commons.enums.Currency;
import com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.dataaccesslayer.Address;
import com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.dataaccesslayer.Contact;
import com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.dataaccesslayer.Membership;
import jakarta.persistence.Embedded;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponseModel extends RepresentationModel<ClientResponseModel> {
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