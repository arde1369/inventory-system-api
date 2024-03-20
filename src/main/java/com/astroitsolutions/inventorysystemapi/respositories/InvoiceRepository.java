package com.astroitsolutions.inventorysystemapi.respositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.astroitsolutions.inventorysystemapi.entities.Invoice;

public interface InvoiceRepository extends MongoRepository<Invoice, Long>{
}