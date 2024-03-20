package com.astroitsolutions.inventorysystemapi.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.astroitsolutions.inventorysystemapi.entities.Invoice;
import com.astroitsolutions.inventorysystemapi.respositories.InvoiceRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class InvoiceService {
    private InvoiceRepository invoiceRepository;

    private ObjectMapper mapper = new ObjectMapper();

    public InvoiceService(InvoiceRepository repository){
        this.invoiceRepository = repository;
    }

    public Invoice saveInvoice(String invoiceRequest) throws JsonProcessingException{
        Invoice invoice = mapper.readValue(invoiceRequest, Invoice.class);
        
        invoice.setCreationTimeStamp(LocalDateTime.now());

        Invoice savedInvoice = invoiceRepository.insert(invoice);

        return savedInvoice;
    }

    public List<Invoice> getAllInvoices(){
        return invoiceRepository.findAll();
    }
}
