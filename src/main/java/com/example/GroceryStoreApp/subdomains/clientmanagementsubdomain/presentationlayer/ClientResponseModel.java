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
    //Client
    private String name;
    @Embedded
    private Contact contactInfo;
    @Embedded
    private Address address;
    @Embedded
    private Membership membership;

}