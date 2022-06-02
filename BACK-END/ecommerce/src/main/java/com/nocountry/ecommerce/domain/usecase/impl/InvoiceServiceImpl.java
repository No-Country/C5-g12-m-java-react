package com.nocountry.ecommerce.domain.usecase.impl;

import com.nocountry.ecommerce.common.exception.error.ResourceNotFoundException;
import com.nocountry.ecommerce.domain.model.Invoice;
import com.nocountry.ecommerce.domain.model.Product;
import com.nocountry.ecommerce.domain.model.User;
import com.nocountry.ecommerce.domain.repository.InvoiceRepository;
import com.nocountry.ecommerce.domain.repository.ProductRepository;
import com.nocountry.ecommerce.domain.repository.UserRepository;
import com.nocountry.ecommerce.domain.usecase.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final InvoiceRepository invoiceRepository;

    @Transactional
    @Override
    public void saveInvoice(Long idUser, List<Long> idProducts) {

        User user = userRepository.findById(idUser).orElseThrow(() -> new ResourceNotFoundException("user", idUser));

        List<Product> listProduct = new ArrayList<>();
        idProducts.forEach(id -> {
            Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("product", id));
            listProduct.add(product);
            product.setStock(product.getStock()-1);
            if (product.getStock() == 0) product.setIsAvailable(false);
            productRepository.save(product);
        });

        Invoice invoice = new Invoice();
        invoice.setUser(user);
        invoice.setProductList(listProduct);
        invoice.setCreationDate(LocalDateTime.now());

        invoiceRepository.save(invoice);
    }
}
