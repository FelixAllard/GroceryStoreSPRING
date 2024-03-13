package com.example.GroceryStoreApp.subdomains.productsmanagementsubdomain.buisnesslayer;



import java.util.List;

import com.example.GroceryStoreApp.commons.enums.Currency;
import com.example.GroceryStoreApp.commons.enums.Price;
import com.example.GroceryStoreApp.commons.identifiers.ClientIdentifier;
import com.example.GroceryStoreApp.commons.identifiers.ProductIdentifier;
import com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.buisnesslayer.ClientService;
import com.example.GroceryStoreApp.subdomains.productsmanagementsubdomain.dataaccesslayer.*;
import com.example.GroceryStoreApp.subdomains.productsmanagementsubdomain.datamapperlayer.ProductRequestMapper;
import com.example.GroceryStoreApp.subdomains.productsmanagementsubdomain.datamapperlayer.ProductResponseMapper;
import com.example.GroceryStoreApp.subdomains.productsmanagementsubdomain.presentationlayer.ProductRequestModel;
import com.example.GroceryStoreApp.subdomains.productsmanagementsubdomain.presentationlayer.ProductResponseModel;
import com.example.GroceryStoreApp.utils.exceptions.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductResponseMapper productResponseMapper;
    private final ProductRequestMapper productRequestMapper;

    public ProductServiceImpl(ProductRepository productRepository,
                              ProductResponseMapper productResponseMapper,
                              ProductRequestMapper productRequestMapper) {
        this.productRepository = productRepository;
        this.productResponseMapper = productResponseMapper;
        this.productRequestMapper = productRequestMapper;
    }

    @Override
    public List<ProductResponseModel> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return productResponseMapper.entityListToResponseModelList(products);
    }

    @Override
    public ProductResponseModel getProductByProductIdentifier_productId(String productId) {
        if(!productRepository.existsProductByProductIdentifier_ProductId(productId))
            throw new NotFoundException("Unknown productId " + productId);
        Product products = productRepository.findProductByProductIdentifier_ProductId(productId);
        return productResponseMapper.entityToResponseModel(products);


    }

    @Override
    public ProductResponseModel createProduct(ProductRequestModel productRequestModel) {
        //We don't depend on other stuff
        Price price = new Price(
                productRequestModel.getValue(),
                Currency.valueOf(productRequestModel.getCurrency())
        );
        Image image = new Image(
                productRequestModel.getUrl(),
                productRequestModel.getAltText()
        );
        Date date = new Date(
                productRequestModel.getDay(),
                productRequestModel.getMonth(),
                productRequestModel.getYear()
        );
        PalletImportedFrom palletImportedFrom = new PalletImportedFrom(
                productRequestModel.getPalletId(),
                productRequestModel.getManufacturer(),
                date

        );
        CategoryArticle categoryArticle = new CategoryArticle(
                productRequestModel.getCategoryName(),
                productRequestModel.getCategoryDescription()
        );



        Product product = productRequestMapper.requestModelToEntity(
                productRequestModel,
                new ProductIdentifier(),
                palletImportedFrom,
                price,
                categoryArticle,
                image
        );
        return productResponseMapper.entityToResponseModel(productRepository.save(product));
    }

    @Override
    public ProductResponseModel updateProduct(ProductRequestModel productRequestModel, String productId) {
        if(!productRepository.existsProductByProductIdentifier_ProductId(productId))
            throw new NotFoundException("Unknown productId " + productId);


        Product product = productRepository.findProductByProductIdentifier_ProductId(productId);
        Price price = new Price(
                productRequestModel.getValue(),
                Currency.valueOf(productRequestModel.getCurrency())
        );
        Image image = new Image(
                productRequestModel.getUrl(),
                productRequestModel.getAltText()
        );
        Date date = new Date(
                productRequestModel.getDay(),
                productRequestModel.getMonth(),
                productRequestModel.getYear()
        );
        PalletImportedFrom palletImportedFrom = new PalletImportedFrom(
                productRequestModel.getPalletId(),
                productRequestModel.getManufacturer(),
                date

        );
        CategoryArticle categoryArticle = new CategoryArticle(
                productRequestModel.getCategoryName(),
                productRequestModel.getCategoryDescription()
        );
        Product updatedProduct = productRequestMapper.requestModelToEntity(
                productRequestModel,
                new ProductIdentifier(),
                palletImportedFrom,
                price,
                categoryArticle,
                image
        );
        updatedProduct.setId(product.getId());
        return productResponseMapper.entityToResponseModel(productRepository.save(updatedProduct));
    }

    @Transactional
    @Override
    public void removeProduct(String productId) {
        if(!productRepository.existsProductByProductIdentifier_ProductId(productId))
            throw new NotFoundException("Unknown productId " + productId);
        productRepository.deleteProductByProductIdentifier_ProductId(productId);
    }
}
