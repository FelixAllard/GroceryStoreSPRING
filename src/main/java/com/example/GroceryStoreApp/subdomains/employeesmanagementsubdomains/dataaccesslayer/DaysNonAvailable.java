package com.example.GroceryStoreApp.subdomains.employeesmanagementsubdomains.dataaccesslayer;


import com.example.GroceryStoreApp.commons.enums.DaysOfTheWeek;
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
public class DaysNonAvailable {
    private boolean fullDay;
    @Embedded
    private Date startOfNonAvailability;
    @Embedded
    private Date endOfNonAvailability;
    private String reason;
    @Enumerated(EnumType.STRING)
    private DaysOfTheWeek weekDay;

}
