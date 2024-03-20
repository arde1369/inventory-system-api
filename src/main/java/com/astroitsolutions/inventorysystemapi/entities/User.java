package com.astroitsolutions.inventorysystemapi.entities;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class User {

    @Id
    private Long id;

    private String firstname;

    private String lastname;

    private String username;

    private String email;

    private Address address;
}
