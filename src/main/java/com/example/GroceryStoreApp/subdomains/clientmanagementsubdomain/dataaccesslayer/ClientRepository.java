package com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.dataaccesslayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findWifeByClientIdentifier_ClientId(String clientId);

    void deleteWifeByClientIdentifier_ClientId(String clientId);

    boolean existsWifeByClientIdentifier_ClientId(String clientId);
}
