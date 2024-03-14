package com.example.GroceryStoreApp.subdomains.employeesmanagementsubdomains.buisnesslayer;


import com.example.GroceryStoreApp.subdomains.employeesmanagementsubdomains.presentationlayer.EmployeeRequestModel;
import com.example.GroceryStoreApp.subdomains.employeesmanagementsubdomains.presentationlayer.EmployeeResponseModel;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponseModel> getAllEmployees();

    EmployeeResponseModel getEmployeeByEmployeeIdentifier_employeeId(String employeeId);

    EmployeeResponseModel createEmployee(EmployeeRequestModel employeeRequestModel);

    EmployeeResponseModel updateEmployee(EmployeeRequestModel employeeRequestModel, String employeeId);

    void removeEmployee(String employeeId);
}
