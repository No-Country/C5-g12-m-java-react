package com.nocountry.ecommerce.ports.input.rs.controller;

import com.nocountry.ecommerce.domain.usecase.InvoiceService;
import com.nocountry.ecommerce.ports.input.rs.api.ApiConstants;
import com.nocountry.ecommerce.ports.input.rs.request.PurchaseRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiConstants.INVOICE_URI)
public class InvoiceController {

    private final InvoiceService invoiceService;


    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @PostMapping
    public void processPurchase(@RequestBody PurchaseRequest request) {
        invoiceService.processPurchaseRequest(request);
    }


}
