package com.example.GroceryStoreApp.subdomains.transactionsmanagementsubdomain.buisnesslayer;

import com.example.GroceryStoreApp.commons.enums.Currency;
import com.example.GroceryStoreApp.commons.enums.Price;
import com.example.GroceryStoreApp.commons.identifiers.PurchaseReceiptIdentifier;
import com.example.GroceryStoreApp.subdomains.transactionsmanagementsubdomain.dataaccesslayer.*;
import com.example.GroceryStoreApp.subdomains.transactionsmanagementsubdomain.datamapperlayer.PurchaseReceiptRequestMapper;
import com.example.GroceryStoreApp.subdomains.transactionsmanagementsubdomain.datamapperlayer.PurchaseReceiptResponseMapper;
import com.example.GroceryStoreApp.subdomains.transactionsmanagementsubdomain.presentationlayer.PurchaseReceiptRequestModel;
import com.example.GroceryStoreApp.subdomains.transactionsmanagementsubdomain.presentationlayer.PurchaseReceiptResponseModel;
import com.example.GroceryStoreApp.utils.exceptions.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseReceiptServiceImpl implements PurchaseReceiptService{
    private final PurchaseReceiptRepository purchaseReceiptRepository;
    private final PurchaseReceiptResponseMapper purchaseReceiptResponseMapper;
    private final PurchaseReceiptRequestMapper purchaseReceiptRequestMapper;

    public PurchaseReceiptServiceImpl(PurchaseReceiptRepository purchaseReceiptRepository,
                                      PurchaseReceiptResponseMapper purchaseReceiptResponseMapper,
                                      PurchaseReceiptRequestMapper purchaseReceiptRequestMapper) {
        this.purchaseReceiptRepository = purchaseReceiptRepository;
        this.purchaseReceiptResponseMapper = purchaseReceiptResponseMapper;
        this.purchaseReceiptRequestMapper = purchaseReceiptRequestMapper;
    }

    @Override
    public List<PurchaseReceiptResponseModel> getAllPurchaseReceipts() {
        List<PurchaseReceipt> purchaseReceipts = purchaseReceiptRepository.findAll();
        return purchaseReceiptResponseMapper.entityListToResponseModelList(purchaseReceipts);
    }

    @Override
    public PurchaseReceiptResponseModel getPurchaseReceiptByPurchaseReceiptIdentifier_purchaseReceiptId(String purchaseReceiptId) {
        if(!purchaseReceiptRepository.existsPurchaseReceiptByPurchaseReceiptIdentifier_PurchaseReceiptId(purchaseReceiptId))
            throw new NotFoundException("Unknown purchaseReceiptId " + purchaseReceiptId);
        PurchaseReceipt purchaseReceipts = purchaseReceiptRepository.findPurchaseReceiptByPurchaseReceiptIdentifier_PurchaseReceiptId(purchaseReceiptId);
        return purchaseReceiptResponseMapper.entityToResponseModel(purchaseReceipts);


    }

    @Override
    public PurchaseReceiptResponseModel createPurchaseReceipt(PurchaseReceiptRequestModel purchaseReceiptRequestModel) {
        //We don't depend on other stuff
        CurrentDate currentDate = new CurrentDate(
                purchaseReceiptRequestModel.getTransactionHour(),
                new Date(
                        purchaseReceiptRequestModel.getDay(),
                        purchaseReceiptRequestModel.getMonth(),
                        purchaseReceiptRequestModel.getYear()
                )
        );
        Price price = new Price(
                purchaseReceiptRequestModel.getValue(),
                Currency.valueOf(purchaseReceiptRequestModel.getCurrency())

        );
        StoreAddress storeAddress = new StoreAddress(
                purchaseReceiptRequestModel.getStreet(),
                purchaseReceiptRequestModel.getCity(),
                purchaseReceiptRequestModel.getState(),
                purchaseReceiptRequestModel.getPostalCode(),
                purchaseReceiptRequestModel.getCountry()
        );
        PurchaseReceipt purchaseReceipt = purchaseReceiptRequestMapper.requestModelToEntity(
                purchaseReceiptRequestModel,
                new PurchaseReceiptIdentifier(),
                currentDate,
                price,
                storeAddress
        );
        return purchaseReceiptResponseMapper.entityToResponseModel(purchaseReceiptRepository.save(purchaseReceipt));
    }

    @Override
    public PurchaseReceiptResponseModel updatePurchaseReceipt(PurchaseReceiptRequestModel purchaseReceiptRequestModel, String purchaseReceiptId) {
        if(!purchaseReceiptRepository.existsPurchaseReceiptByPurchaseReceiptIdentifier_PurchaseReceiptId(purchaseReceiptId))
            throw new NotFoundException("Unknown purchaseReceiptId " + purchaseReceiptId);


        PurchaseReceipt purchaseReceipt = purchaseReceiptRepository.findPurchaseReceiptByPurchaseReceiptIdentifier_PurchaseReceiptId(purchaseReceiptId);
        CurrentDate currentDate = new CurrentDate(
                purchaseReceiptRequestModel.getTransactionHour(),
                new Date(
                        purchaseReceiptRequestModel.getDay(),
                        purchaseReceiptRequestModel.getMonth(),
                        purchaseReceiptRequestModel.getYear()
                )
        );
        Price price = new Price(
                purchaseReceiptRequestModel.getValue(),
                Currency.valueOf(purchaseReceiptRequestModel.getCurrency())

        );
        StoreAddress storeAddress = new StoreAddress(
                purchaseReceiptRequestModel.getStreet(),
                purchaseReceiptRequestModel.getCity(),
                purchaseReceiptRequestModel.getState(),
                purchaseReceiptRequestModel.getPostalCode(),
                purchaseReceiptRequestModel.getCountry()
        );
        PurchaseReceipt updatedPurchaseReceipt = purchaseReceiptRequestMapper.requestModelToEntity(
                purchaseReceiptRequestModel,
                new PurchaseReceiptIdentifier(),
                currentDate,
                price,
                storeAddress
        );
        updatedPurchaseReceipt.setId(purchaseReceipt.getId());
        return purchaseReceiptResponseMapper.entityToResponseModel(purchaseReceiptRepository.save(updatedPurchaseReceipt));
    }

    @Transactional
    @Override
    public void removePurchaseReceipt(String purchaseReceiptId) {
        if(!purchaseReceiptRepository.existsPurchaseReceiptByPurchaseReceiptIdentifier_PurchaseReceiptId(purchaseReceiptId))
            throw new NotFoundException("Unknown purchaseReceiptId " + purchaseReceiptId);
        purchaseReceiptRepository.deletePurchaseReceiptByPurchaseReceiptIdentifier_PurchaseReceiptId(purchaseReceiptId);
    }
}
