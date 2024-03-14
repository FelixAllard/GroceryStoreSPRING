package com.example.GroceryStoreApp.subdomains.productsmanagementsubdomain.buisnesslayer;


import com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.presentationlayer.ClientRequestModel;
import com.example.GroceryStoreApp.subdomains.productsmanagementsubdomain.presentationlayer.ProductRequestModel;
import com.example.GroceryStoreApp.subdomains.productsmanagementsubdomain.presentationlayer.ProductResponseModel;

import java.util.List;
public interface ProductService {
    List<ProductResponseModel> getAllProducts();

    ProductResponseModel getProductByProductIdentifier_productId(String productId);

    ProductResponseModel createProduct(ProductRequestModel productRequestModel);

    ProductResponseModel updateProduct(ProductRequestModel productRequestModel, String productId);

    void removeProduct(String productId);

}
