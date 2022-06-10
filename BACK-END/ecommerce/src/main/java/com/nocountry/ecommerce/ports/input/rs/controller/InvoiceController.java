package com.nocountry.ecommerce.ports.input.rs.controller;

import com.nocountry.ecommerce.domain.usecase.InvoiceService;
import com.nocountry.ecommerce.ports.input.rs.api.ApiConstants;
import com.nocountry.ecommerce.ports.input.rs.mapper.InvoiceMapper;
import com.nocountry.ecommerce.ports.input.rs.request.PurchaseRequest;
import com.nocountry.ecommerce.ports.input.rs.response.InvoiceResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nocountry.ecommerce.ports.input.rs.api.ApiConstants.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(INVOICE_URI)
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final InvoiceMapper invoiceMapper;

    //=========================Get invoice=========================//

    @GetMapping(path = "/{id}")
    @PreAuthorize(BOTH)
    public ResponseEntity<List<InvoiceResponse>> getInvoices(@PathVariable("id") Long id) {
        List<InvoiceResponse> responses = invoiceMapper.ListInvoiceToInvoiceResponse(invoiceService.getInvoices(id));
        return ResponseEntity.ok(responses);
    }

    //=========================Buy products=========================//

    @PreAuthorize(BOTH)
    @PostMapping
    public void processPurchase(@RequestBody PurchaseRequest request) {
        invoiceService.processPurchaseRequest(request);
    }


}
