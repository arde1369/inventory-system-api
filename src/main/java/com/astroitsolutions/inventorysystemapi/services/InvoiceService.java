package com.astroitsolutions.inventorysystemapi.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.astroitsolutions.inventorysystemapi.entities.Invoice;
import com.astroitsolutions.inventorysystemapi.entities.Order;
import com.astroitsolutions.inventorysystemapi.respositories.InvoiceRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class InvoiceService {
    private InvoiceRepository invoiceRepository;

    private ObjectMapper mapper = new ObjectMapper();

    private final List<Invoice> TEST_INVOICE_LIST = new ArrayList<>();

    public InvoiceService(InvoiceRepository repository){
        this.invoiceRepository = repository;
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("1ab", "Beaker", 1));
        orders.add(new Order("1ac", "Bunsen Burner", 1));
        orders.add(new Order("2ab", "Syringe", 1));
        orders.add(new Order("2bc", "Microscope", 1));

        Invoice invoice = new Invoice();
        invoice.setItems(orders);
        invoice.setId(1L);
        invoice.setCreationTimeStamp(LocalDateTime.now());

        TEST_INVOICE_LIST.add(invoice);
    }

    public Invoice saveInvoice(String invoiceRequest) throws JsonProcessingException{
        Invoice invoice = mapper.readValue(invoiceRequest, Invoice.class);
        
        invoice.setCreationTimeStamp(LocalDateTime.now());

        // Invoice savedInvoice = invoiceRepository.insert(invoice);
        Invoice savedInvoice = invoice;

        return savedInvoice;
    }

    public List<Invoice> getAllInvoices(){
        return TEST_INVOICE_LIST;
        // return invoiceRepository.findAll();
    }
}
