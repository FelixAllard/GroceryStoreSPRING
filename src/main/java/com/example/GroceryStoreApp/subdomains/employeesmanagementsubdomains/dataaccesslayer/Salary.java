package com.example.GroceryStoreApp.subdomains.employeesmanagementsubdomains.dataaccesslayer;


import com.example.GroceryStoreApp.commons.enums.Currency;
import com.example.GroceryStoreApp.commons.enums.PaymentMethod;
import com.example.GroceryStoreApp.commons.enums.Price;
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
public class Salary {
    @Embedded
    private Price SalaryPrice;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;


}
