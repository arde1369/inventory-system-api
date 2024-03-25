package com.astroitsolutions.inventorysystemapi.entities;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    @Id
    String id;
    String name;
}
