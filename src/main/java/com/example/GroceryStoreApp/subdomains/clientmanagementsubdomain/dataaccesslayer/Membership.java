package com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.dataaccesslayer;

import com.example.GroceryStoreApp.commons.enums.Price;
import com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.dataaccesslayer.MembershipStatus;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Membership {
    private double totalSpent;
    private int numberOfPoints;

    @Enumerated(EnumType.STRING)
    private MembershipStatus membershipStatus;

    @Embedded
    private Price price;
}
