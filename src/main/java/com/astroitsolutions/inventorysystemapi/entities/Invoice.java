package com.astroitsolutions.inventorysystemapi.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Invoice {
    
    @Id
    private Long id;
    
    private List<Order> items;

    private LocalDateTime creationTimeStamp;
}
