package com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.buisnesslayer;

import com.jmorissette.weddingplanner.subdomains.accessorymanagementsubdomain.presentationlayer.DecorationModel.DecorationRequestModel;
import com.jmorissette.weddingplanner.subdomains.accessorymanagementsubdomain.presentationlayer.DecorationModel.DecorationResponseModel;

import java.util.List;

public interface DecorationService {

    List<DecorationResponseModel> getAllDecorations();

    DecorationResponseModel getDecorationByDecorationIdentifier_decorationId(String decorationId);

    DecorationResponseModel createDecoration(DecorationRequestModel decorationRequestModel);

    DecorationResponseModel updateDecoration(DecorationRequestModel decorationRequestModel, String decorationId);

    void removeDecoration(String decorationId);

}
