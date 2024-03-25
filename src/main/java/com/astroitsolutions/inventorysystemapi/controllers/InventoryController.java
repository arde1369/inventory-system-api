package com.astroitsolutions.inventorysystemapi.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.astroitsolutions.inventorysystemapi.entities.Item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping(("/inventory"))
public class InventoryController {

    private List<Item> dummyItems = new ArrayList<>();

    public InventoryController(){
        Item item1 = new Item("1ab","Beaker");
        Item item2 = new Item("1ac","Bunsen Burner");
        Item item3 = new Item("1ab","Syringe");
        Item item4 = new Item("1bc","Microscope");
        dummyItems.add(item1);
        dummyItems.add(item2);
        dummyItems.add(item3);
        dummyItems.add(item4);
    }

    @GetMapping("/getAllItems")
    public ResponseEntity<List<Item>> getMethodName() {
        return ResponseEntity.status(200).body(dummyItems);
    }
    
    
}
