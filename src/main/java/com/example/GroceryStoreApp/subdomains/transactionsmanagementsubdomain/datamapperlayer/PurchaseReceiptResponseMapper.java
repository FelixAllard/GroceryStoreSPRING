package com.example.GroceryStoreApp.subdomains.transactionsmanagementsubdomain.datamapperlayer;

import com.example.GroceryStoreApp.subdomains.transactionsmanagementsubdomain.dataaccesslayer.PurchaseReceipt;
import com.example.GroceryStoreApp.subdomains.transactionsmanagementsubdomain.presentationlayer.PurchaseReceiptController;
import com.example.GroceryStoreApp.subdomains.transactionsmanagementsubdomain.presentationlayer.PurchaseReceiptResponseModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring")
public interface PurchaseReceiptResponseMapper {
    @Mapping(expression = "java(purchaseReceipt.getPurchaseReceiptIdentifier().getPurchaseReceiptId())", target = "purchaseReceiptId()")
    @Mapping(expression = "java(purchaseReceipt.getAmount())", target = "amount")
    @Mapping(expression = "java(purchaseReceipt.getCurrentDate().getTransactionHour())", target = "transactionHour")
    @Mapping(expression = "java(purchaseReceipt.getCurrentDate().getDate().getDay())", target = "day")
    @Mapping(expression = "java(purchaseReceipt.getCurrentDate().getDate().getMonth())", target = "month")
    @Mapping(expression = "java(purchaseReceipt.getCurrentDate().getDate().getYear())", target = "year")
    @Mapping(expression = "java(purchaseReceipt.getPrice().getValue())",target = "value")
    @Mapping(expression = "java(purchaseReceipt.getPrice().getCurrency().name())",target = "currency")
    @Mapping(expression = "java(purchaseReceipt.getStoreAddress().getStreet())",target = "street")
    @Mapping(expression = "java(purchaseReceipt.getStoreAddress().getCity())",target = "city")
    @Mapping(expression = "java(purchaseReceipt.getStoreAddress().getState())",target = "state")
    @Mapping(expression = "java(purchaseReceipt.getStoreAddress().getPostalCode())",target = "postalCode")
    @Mapping(expression = "java(purchaseReceipt.getStoreAddress().getCountry())",target = "country")

    PurchaseReceiptResponseModel entityToResponseModel(PurchaseReceipt purchaseReceipt);

    List<PurchaseReceiptResponseModel> entityListToResponseModelList(List<PurchaseReceipt> purchaseReceipts);

    @AfterMapping
    default void addLinks(@MappingTarget PurchaseReceiptResponseModel model){
        Link selfLink = linkTo(methodOn(PurchaseReceiptController.class)
                        .getPurchaseReceiptByPurchaseReceiptId(model.getPurchaseReceiptId()))
                .withSelfRel();
        model.add(selfLink);

        Link productsLink =
                linkTo(methodOn(PurchaseReceiptController.class)
                        .getPurchaseReceipts())
                        .withRel("all purchaseReceipts");
        model.add(productsLink);

    }
}
