package com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.datamapperlayer;


import com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.dataaccesslayer.Client;
import com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.presentationlayer.ClientController;
import com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.presentationlayer.ClientResponseModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring")
public interface ClientResponseMapper {

    @Mapping(expression = "java(client.getClientIdentifier().getClientId())", target = "clientId")
    @Mapping(expression = "java(client.getName())", target = "name")
    @Mapping(expression = "java(client.getContact().getEmail())", target = "email")
    @Mapping(expression = "java(client.getContact().getPhone())", target = "phone")
    @Mapping(expression = "java(client.getAddress().getStreet())", target = "street")
    @Mapping(expression = "java(client.getAddress().getCity())", target = "city")
    @Mapping(expression = "java(client.getAddress().getState())", target = "state")
    @Mapping(expression = "java(client.getAddress().getPostalCode())", target = "postalCode")
    @Mapping(expression = "java(client.getAddress().getCountry())", target = "country")
    @Mapping(expression = "java(client.getMemberShip().getTotalSpent())", target = "totalSpent")
    @Mapping(expression = "java(client.getMemberShip().getNumberOfPoints())", target = "numberOfPoints")
    @Mapping(expression = "java(client.getMemberShip().getMembershipStatus())", target = "membershipStatus")
    @Mapping(expression = "java(client.getMembership().getPrice().getValue())", target = "value")
    @Mapping(expression = "java(client.getMembership().getPrice().getCurrency())", target = "currency")
    ClientResponseModel entityToResponseModel(Client client);

    List<ClientResponseModel> entityListToResponseModelList(List<Client> clients);

    @AfterMapping
    default void addLinks(@MappingTarget ClientResponseModel model){
        Link selfLink = linkTo(methodOn(ClientController.class)
                .getClientByClientId(model.getClientId()))
                .withSelfRel();
        model.add(selfLink);

        Link clientsLink =
                linkTo(methodOn(ClientController.class)
                        .getClients())
                        .withRel("all clients");
        model.add(clientsLink);

    }


}
