package com.nocountry.ecommerce.ports.input.rs.mapper;

import com.nocountry.ecommerce.domain.model.Invoice;
import com.nocountry.ecommerce.ports.input.rs.request.InvoiceRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    @Mapping(source = "idUser", target = "user.id")
   // @Mapping(source = "listProducts", target = "invoice.productList.id")
    Invoice InvoiceRequestToInvoice(InvoiceRequest request);


}
