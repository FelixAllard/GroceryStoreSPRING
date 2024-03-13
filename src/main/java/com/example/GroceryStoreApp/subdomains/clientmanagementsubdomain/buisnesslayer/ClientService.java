package com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.buisnesslayer;


import com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.presentationlayer.ClientRequestModel;
import com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.presentationlayer.ClientResponseModel;

import java.util.List;

public interface ClientService {
    List<ClientResponseModel> getAllClients();

    ClientResponseModel getClientByClientIdentifier_clientId(String clientId);

    ClientResponseModel createClient(ClientRequestModel clientRequestModel);

    ClientResponseModel updateClient(ClientRequestModel clientRequestModel, String clientId);

    void removeClient(String clientId);

}
