package com.astroitsolutions.inventorysystemapi.entities;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Address {
    @Id
    private Long id;

    private String street;

    private String aptOrUnit;

    private String city;

    private String state;

    private String zipCode;
}
