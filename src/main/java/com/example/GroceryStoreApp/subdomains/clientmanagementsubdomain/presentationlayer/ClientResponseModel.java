package com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.presentationlayer;

import com.example.GroceryStoreApp.commons.enums.Currency;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponseModel extends RepresentationModel<ClientResponseModel> {
    //Client
    private String name;
    private Contact contactInfo;



    private String decorationId;

    private BigDecimal value;

    private Currency currency;

    private String name;

    private String description;

}