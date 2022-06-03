package com.nocountry.ecommerce.ports.input.rs.mapper;

import com.nocountry.ecommerce.domain.model.Invoice;
import com.nocountry.ecommerce.domain.model.Product;
import com.nocountry.ecommerce.ports.input.rs.request.InvoiceRequest;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    @Mapping(source = "idUser", target = "user.id")
   // @IterableMapping(qualifiedByName = "productInToProduct")
    @IterableMapping(qualifiedByName = "toProduct")
    Invoice InvoiceRequestToInvoice(InvoiceRequest request);

    @Named("productInToProduct")
    List<Product> productInToProduct(List<Long> id);

    @Named("toProduct")
    Product map(Long value);

}
