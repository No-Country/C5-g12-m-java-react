package com.nocountry.ecommerce.domain.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "invoice")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Invoice {


    @Id
    @Column(name = "invoice_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "invoice_product",
            joinColumns =
            @JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id"),
            inverseJoinColumns =
            @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    )
    private List<Product> productList;

    @Column(name = "date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime creationDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoice invoice = (Invoice) o;

        if (!id.equals(invoice.id)) return false;
        if (!user.equals(invoice.user)) return false;
        return productList.equals(invoice.productList);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
