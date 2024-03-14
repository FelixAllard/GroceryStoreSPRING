package com.example.GroceryStoreApp.subdomains.employeesmanagementsubdomains.dataaccesslayer;

import com.example.GroceryStoreApp.commons.enums.CurrentEmploymentStatus;
import com.example.GroceryStoreApp.commons.enums.Role;
import com.example.GroceryStoreApp.commons.identifiers.EmployeeIdentifier;
import com.example.GroceryStoreApp.subdomains.productsmanagementsubdomain.dataaccesslayer.Date;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private int age;
    @Enumerated
    private EmployeeIdentifier employeeId;

    @Enumerated(EnumType.STRING)
    private CurrentEmploymentStatus currentEmploymentStatus;
    @Embedded
    private DaysNonAvailable daysNonAvailable;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Embedded
    private Salary salary;

    public Employee(
            @NotNull CurrentEmploymentStatus currentEmploymentStatus,
            @NotNull DaysNonAvailable daysNonAvailable,
            @NotNull Salary salary
    ){
        this.currentEmploymentStatus = currentEmploymentStatus;
        this.daysNonAvailable = daysNonAvailable;
        this.salary = salary;
    }
}
