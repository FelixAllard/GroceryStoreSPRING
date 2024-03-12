package com.example.GroceryStoreApp.subdomains.clientmanagementsubdomain.dataaccesslayer;
import com.example.GroceryStoreApp.commons.identifiers.ClientIdentifier;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client")
@Data
@NoArgsConstructor
public class Client {
    //Just always have this I guess
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String name;
    @Embedded
    private Contact contact;
    private String paymentMethod;

    @Embedded
    private ClientIdentifier clientIdentifier;

    @Embedded
    private Address address;

    @Embedded
    private Membership membership;
}
