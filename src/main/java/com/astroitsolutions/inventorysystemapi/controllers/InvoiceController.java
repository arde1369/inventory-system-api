package com.astroitsolutions.inventorysystemapi.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.astroitsolutions.inventorysystemapi.entities.Invoice;
import com.astroitsolutions.inventorysystemapi.services.InvoiceService;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@Slf4j
public class InvoiceController {
    

    private InvoiceService invoiceService;

    public InvoiceController(InvoiceService service){
        this.invoiceService = service;
    }

    @PostMapping("path")
    public ResponseEntity<Invoice> saveInvoice(@RequestBody String invoiceRequest) {
        Invoice savedInvoice = null;
        HttpStatus status = null;
        try{
            savedInvoice = invoiceService.saveInvoice(invoiceRequest);
            status = HttpStatus.OK;
        } catch(JsonProcessingException e){
            log.error("Error occurres processing Json: ", e);
            status = HttpStatus.BAD_REQUEST;
        } catch(Exception e){
            log.error("Internal Server Error: ", e);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        
        return ResponseEntity.status(status).body(savedInvoice);
    }

    @GetMapping("/invoice/getAllInvoices")
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        List<Invoice> invoices = null;
        HttpStatus status = null;
        try{
            invoices = invoiceService.getAllInvoices();
            status = HttpStatus.OK;
        } catch(Exception e){
            log.error("Internal Server Error: ", e);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return ResponseEntity.status(status).body(invoices);
    }
}
