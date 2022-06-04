package com.nocountry.ecommerce.domain.repository;

import com.nocountry.ecommerce.domain.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
