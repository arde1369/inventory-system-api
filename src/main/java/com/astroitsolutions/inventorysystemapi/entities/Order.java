package com.astroitsolutions.inventorysystemapi.entities;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Order {
    @Id
    private Long id;
    private String itemCode;
    private int itemQuantity;
}
