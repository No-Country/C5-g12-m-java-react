package com.nocountry.ecommerce.domain.usecase.impl;

import com.nocountry.ecommerce.domain.model.Invoice;
import com.nocountry.ecommerce.domain.model.Product;
import com.nocountry.ecommerce.domain.model.User;
import com.nocountry.ecommerce.domain.repository.InvoiceRepository;
import com.nocountry.ecommerce.domain.usecase.InvoiceService;
import com.nocountry.ecommerce.domain.usecase.ProductService;
import com.nocountry.ecommerce.domain.usecase.UserService;
import com.nocountry.ecommerce.ports.input.rs.request.ProductRequestSimple;
import com.nocountry.ecommerce.ports.input.rs.request.PurchaseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final UserService userService;
    private final ProductService productService;
    private final InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> getInvoices(Long id) {
        return invoiceRepository.findByUserId(id);
    }

    @Override
    @Transactional
    public void processPurchaseRequest(PurchaseRequest request) {

        User user = userService.getByIdIfExist(request.getIdUser());
        List<Product> listProducts = new ArrayList<>();

        for (ProductRequestSimple p : request.getListProducts()) {
            {
                Product productDB = productService.getByIdIfExist(p.getId());

                discountProduct(p, productDB);
                disableProduct(productDB);

                productService.save(productDB);
                listProducts.add(productDB);
            }
        }

        createAndSaveInvoice(user, listProducts);
    }

    private void createAndSaveInvoice(User user, List<Product> listProducts) {

        Invoice invoice = new Invoice();
        invoice.setUser(user);
        invoice.setProductList(listProducts);
        invoice.setCreationDate(LocalDateTime.now());

        invoiceRepository.save(invoice);

    }

    private void disableProduct(Product productDB) {
        if (productDB.getStock() == 0) productDB.setIsAvailable(false);
    }

    private void discountProduct(ProductRequestSimple p, Product productDB) {
        if (p.getAmount() > productDB.getStock() || !productDB.getIsAvailable()) throw new RuntimeException("no stock");
        productDB.setStock(productDB.getStock() - p.getAmount());
    }

}
