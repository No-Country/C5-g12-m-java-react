package com.nocountry.ecommerce.domain.usecase;

import com.nocountry.ecommerce.domain.model.Invoice;

public interface InvoiceService {

    void saveInvoice(Invoice invoice);

}
