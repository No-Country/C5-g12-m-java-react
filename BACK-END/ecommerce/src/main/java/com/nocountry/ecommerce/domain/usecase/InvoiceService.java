package com.nocountry.ecommerce.domain.usecase;

import java.util.List;

public interface InvoiceService {

    void saveInvoice(Long idUser, List<Long> idProducts);

}
