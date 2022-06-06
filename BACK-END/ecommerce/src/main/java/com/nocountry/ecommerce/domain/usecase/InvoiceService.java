package com.nocountry.ecommerce.domain.usecase;

import com.nocountry.ecommerce.ports.input.rs.request.PurchaseRequest;

public interface InvoiceService {

    void processPurchaseRequest(PurchaseRequest request);

}
