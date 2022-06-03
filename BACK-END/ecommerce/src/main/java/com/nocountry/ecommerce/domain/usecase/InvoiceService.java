package com.nocountry.ecommerce.domain.usecase;

import com.nocountry.ecommerce.ports.input.rs.request.InvoiceRequest;

public interface InvoiceService {

    void saveInvoice(InvoiceRequest request);

}
