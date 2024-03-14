package com.example.GroceryStoreApp.subdomains.transactionsmanagementsubdomain.datamapperlayer;

import com.example.GroceryStoreApp.commons.enums.Price;
import com.example.GroceryStoreApp.commons.identifiers.PurchaseReceiptIdentifier;
import com.example.GroceryStoreApp.subdomains.transactionsmanagementsubdomain.dataaccesslayer.CurrentDate;
import com.example.GroceryStoreApp.subdomains.transactionsmanagementsubdomain.dataaccesslayer.PurchaseReceipt;
import com.example.GroceryStoreApp.subdomains.transactionsmanagementsubdomain.dataaccesslayer.StoreAddress;
import com.example.GroceryStoreApp.subdomains.transactionsmanagementsubdomain.presentationlayer.PurchaseReceiptRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PurchaseReceiptRequestMapper {

    @Mapping(target = "id", ignore = true)
    PurchaseReceipt requestModelToEntity(
            PurchaseReceiptRequestModel purchaseReceiptRequestModel,
            PurchaseReceiptIdentifier purchaseReceiptIdentifier,
            CurrentDate currentDate,
            Price price,
            StoreAddress storeAddress
    );
}
