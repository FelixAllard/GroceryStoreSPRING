package com.example.GroceryStoreApp.subdomains.employeesmanagementsubdomains.datamapperlayer;


import com.example.GroceryStoreApp.commons.identifiers.EmployeeIdentifier;
import com.example.GroceryStoreApp.subdomains.employeesmanagementsubdomains.dataaccesslayer.DaysNonAvailable;
import com.example.GroceryStoreApp.subdomains.employeesmanagementsubdomains.dataaccesslayer.Employee;
import com.example.GroceryStoreApp.subdomains.employeesmanagementsubdomains.dataaccesslayer.Salary;
import com.example.GroceryStoreApp.subdomains.employeesmanagementsubdomains.presentationlayer.EmployeeRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeRequestMapper {
    @Mapping(target = "id", ignore = true)
    Employee requestModelToEntity(EmployeeRequestModel employeeRequestModel,
                                  EmployeeIdentifier employeeIdentifier,
                                  DaysNonAvailable daysNonAvailable,
                                  Salary salary
    );
    //IF ERROR, ADD ENUMERATOR
}