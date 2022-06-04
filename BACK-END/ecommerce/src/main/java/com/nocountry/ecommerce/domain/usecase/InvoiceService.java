package com.nocountry.ecommerce.domain.usecase;

import com.nocountry.ecommerce.ports.input.rs.request.purchaseRequest;

public interface InvoiceService {

    void processPurchaseRequest(purchaseRequest request);

}
