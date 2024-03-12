package com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.datamapperlayer;



import com.example.GroceryStoreApp.commons.identifiers.ClientIdentifier;
import com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.dataaccesslayer.Address;
import com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.dataaccesslayer.Client;
import com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.dataaccesslayer.Contact;
import com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.dataaccesslayer.Membership;
import com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.presentationlayer.ClientRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring")
public interface ClientRequestMapper {
    @Mapping(target = "id", ignore = true)
    Client requestModelToEntity(ClientRequestModel clientRequestModel,
                                ClientIdentifier decorationIdentifier,
                                Contact contact,
                                Address address,
                                Membership membership

    );
}
