package com.nocountry.ecommerce.ports.input.rs.controller;

import com.nocountry.ecommerce.domain.model.Product;
import com.nocountry.ecommerce.domain.usecase.InvoiceService;
import com.nocountry.ecommerce.ports.input.rs.api.ApiConstants;
import com.nocountry.ecommerce.ports.input.rs.mapper.InvoiceMapper;
import com.nocountry.ecommerce.ports.input.rs.mapper.ProductMapper;
import com.nocountry.ecommerce.ports.input.rs.request.InvoiceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiConstants.INVOICE_URI)
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final InvoiceMapper mapper;
    private final ProductMapper productMapper;


    @PostMapping
    public void createInvoice(@Valid @NotEmpty Long idUser, @Valid @NotEmpty List<Long> listProducts) {

        List<Product> products = productMapper.listProductIdToProductList(listProducts);

        InvoiceRequest request = new InvoiceRequest(idUser, products);

        invoiceService.saveInvoice(mapper.InvoiceRequestToInvoice(request));

    }


}
