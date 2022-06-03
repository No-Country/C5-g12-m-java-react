package com.nocountry.ecommerce.domain.usecase.impl;

import com.nocountry.ecommerce.common.exception.error.ResourceNotFoundException;
import com.nocountry.ecommerce.domain.model.Invoice;
import com.nocountry.ecommerce.domain.model.Product;
import com.nocountry.ecommerce.domain.model.User;
import com.nocountry.ecommerce.domain.repository.InvoiceRepository;
import com.nocountry.ecommerce.domain.repository.ProductRepository;
import com.nocountry.ecommerce.domain.repository.UserRepository;
import com.nocountry.ecommerce.domain.usecase.InvoiceService;
import com.nocountry.ecommerce.ports.input.rs.request.InvoiceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final InvoiceRepository invoiceRepository;

    @Override
    @Transactional
    public void saveInvoice(InvoiceRequest newInvoice) {

        Long idUser = newInvoice.getIdUser();
        User user = userRepository.findById(idUser).orElseThrow(() -> new ResourceNotFoundException("user", idUser));

        List<Product> listProduct = new ArrayList<>();
        List<Long> listProductRequest = newInvoice.getListProducts();

        //producto,cantidad
        Map<Long, Integer> map = listProductRequest.stream()
                .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));


        for (Map.Entry<Long, Integer> m : map.entrySet()) {
            Product product = productRepository.findById(m.getKey()).orElseThrow(() -> new ResourceNotFoundException("product", m.getKey()));
            if (m.getValue() > product.getStock() || !product.getIsAvailable()) throw new RuntimeException("no stock");

            product.setStock(product.getStock() - m.getValue());
            if (product.getStock() == 0) product.setIsAvailable(false);
            productRepository.save(product);
        }

        Invoice invoice = new Invoice();
        invoice.setUser(user);
        invoice.setProductList(listProduct);
        invoice.setCreationDate(LocalDateTime.now());

        invoiceRepository.save(invoice);
    }


}
