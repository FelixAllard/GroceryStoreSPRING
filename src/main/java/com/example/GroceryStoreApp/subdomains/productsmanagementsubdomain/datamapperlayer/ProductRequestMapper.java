package com.example.GroceryStoreApp.subdomains.productsmanagementsubdomain.datamapperlayer;


import com.example.GroceryStoreApp.commons.enums.Price;
import com.example.GroceryStoreApp.commons.identifiers.ProductIdentifier;
import com.example.GroceryStoreApp.subdomains.productsmanagementsubdomain.dataaccesslayer.CategoryArticle;
import com.example.GroceryStoreApp.subdomains.productsmanagementsubdomain.dataaccesslayer.Image;
import com.example.GroceryStoreApp.subdomains.productsmanagementsubdomain.dataaccesslayer.PalletImportedFrom;
import com.example.GroceryStoreApp.subdomains.productsmanagementsubdomain.dataaccesslayer.Product;
import com.example.GroceryStoreApp.subdomains.productsmanagementsubdomain.presentationlayer.ProductRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductRequestMapper {
    @Mapping(target = "id", ignore = true)
    Product requestModelToEntity(
            ProductRequestModel productRequestModel,
            ProductIdentifier productIdentifier,
            PalletImportedFrom palletImportedFrom,
            Price price,
            CategoryArticle categoryArticle,
            Image image
    );
}
