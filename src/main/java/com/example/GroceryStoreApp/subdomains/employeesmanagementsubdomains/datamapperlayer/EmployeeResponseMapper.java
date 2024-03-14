package com.example.GroceryStoreApp.subdomains.employeesmanagementsubdomains.datamapperlayer;




import com.example.GroceryStoreApp.subdomains.employeesmanagementsubdomains.dataaccesslayer.Employee;
import com.example.GroceryStoreApp.subdomains.employeesmanagementsubdomains.presentationlayer.EmployeeController;
import com.example.GroceryStoreApp.subdomains.employeesmanagementsubdomains.presentationlayer.EmployeeResponseModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeResponseMapper {

    @Mapping(expression = "java(employee.getEmployeeIdentifier().getEmployeeId())", target = "employeeId")
    @Mapping(expression = "java(employee.getName())", target = "age")
    @Mapping(expression = "java(employee.getCurrentEmploymentStatus().name())", target = "currentEmploymentStatus")
    @Mapping(expression = "java(employee.getDaysNonAvailable().getFullDay())", target = "fullDay")
    @Mapping(expression = "java(employee.getDaysNonAvailable().getDate().getDay())", target = "startDay")
    @Mapping(expression = "java(employee.getDaysNonAvailable().getDate().getMonth())", target = "startMonth")
    @Mapping(expression = "java(employee.getDaysNonAvailable().getDate().getYear())", target = "startYear")
    @Mapping(expression = "java(employee.getDaysNonAvailable().getDate().getDay())", target = "endDay")
    @Mapping(expression = "java(employee.getDaysNonAvailable().getDate().getMonth())", target = "endMonth")
    @Mapping(expression = "java(employee.getDaysNonAvailable().getDate().getYear())", target = "endYear")
    @Mapping(expression = "java(employee.getDaysNonAvailable().getReason())", target = "reason")
    @Mapping(expression = "java(employee.getDaysNonAvailable().getDaysOfTheWeek().name())", target = "daysOfTheWeek")
    @Mapping(expression = "java(employee.getSalary().getValue())", target = "value")
    @Mapping(expression = "java(employee.getSalary().getCurrency())", target = "currency")
    @Mapping(expression = "java(employee.getSalary().getPaymentMethod())", target = "paymentMethod")
    EmployeeResponseModel entityToResponseModel(Employee employee);

    List<EmployeeResponseModel> entityListToResponseModelList(List<Employee> employees);

    @AfterMapping
    default void addLinks(@MappingTarget EmployeeResponseModel model){
        Link selfLink = linkTo(methodOn(EmployeeController.class)
                .getEmployeeByEmployeeId(model.getEmployeeId()))
                .withSelfRel();
        model.add(selfLink);

        Link employeesLink =
                linkTo(methodOn(EmployeeController.class)
                        .getEmployees())
                        .withRel("all employee");
        model.add(employeesLink);

    }
}
