package com.nocountry.ecommerce.domain.usecase;

import com.nocountry.ecommerce.domain.model.Invoice;
import com.nocountry.ecommerce.ports.input.rs.request.PurchaseRequest;

import java.util.List;

public interface InvoiceService {

    void processPurchaseRequest(PurchaseRequest request);

    List<Invoice> getInvoices(Long id);
}
