package com.example.GroceryStoreApp.subdomains.productsmanagementsubdomain.datamapperlayer;


import com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.presentationlayer.ClientController;
import com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.presentationlayer.ClientResponseModel;
import com.example.GroceryStoreApp.subdomains.productsmanagementsubdomain.dataaccesslayer.Product;
import com.example.GroceryStoreApp.subdomains.productsmanagementsubdomain.presentationlayer.ProductController;
import com.example.GroceryStoreApp.subdomains.productsmanagementsubdomain.presentationlayer.ProductResponseModel;
import org.mapstruct.*;
import org.mapstruct.Mapper;
import org.springframework.hateoas.Link;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Mapper(componentModel = "spring")
public interface ProductResponseMapper {
    @Mapping(expression = "java(product.getProductIdentifier().getProductId())", target="productId")
    @Mapping(expression = "java(product.getName())", target="name")
    @Mapping(expression = "java(product.getDescription())",target="description")
    @Mapping(expression = "java(product.getPalletImportedFrom().getPalletId())",target = "palletId")
    @Mapping(expression = "java(product.getPalletImportedFrom().getManufacturer())",target = "manufacturer")
    @Mapping(expression = "java(product.getPalletImportedFrom().getArrivalDate().getDay())",target = "day")
    @Mapping(expression = "java(product.getPalletImportedFrom().getArrivalDate().getMonth())",target = "month")
    @Mapping(expression = "java(product.getPalletImportedFrom().getArrivalDate().getYear())",target = "year")
    @Mapping(expression = "java(product.getProductAvailability().name())", target = "productAvailability")
    @Mapping(expression = "java(product.getPrice().getValue())", target="value")
    @Mapping(expression = "java(product.getPrice().getCurrency().name())", target="currency")
    @Mapping(expression = "java(product.getCategoryArticle().getCategoryName())", target = "categoryName")
    @Mapping(expression = "java(product.getCategoryArticle().getCategoryDescription())", target = "categoryDescription")
    @Mapping(expression = "java(product.getImage().getUrl())", target="url")
    @Mapping(expression = "java(product.getImage().getAltText())", target="altText")
    ProductResponseModel entityToResponseModel(Product product);
    List<ProductResponseModel> entityListToResponseModelList(List<Product> products);

    @AfterMapping
    default void addLinks(@MappingTarget ProductResponseModel model){
        Link selfLink = linkTo(methodOn(ProductController.class)
                .getProductByProductId(model.getProductId()))
                .withSelfRel();
        model.add(selfLink);

        Link productsLink =
                linkTo(methodOn(ProductController.class)
                        .getProducts())
                        .withRel("all products");
        model.add(productsLink);

    }
}
