package com.nocountry.ecommerce.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Invoice")
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
            name="invoice_product",
            joinColumns=
            @JoinColumn(name="invoice", referencedColumnName="invoice_id"),
            inverseJoinColumns=
            @JoinColumn(name="product", referencedColumnName="product_id")
    )
    private List<Product> productList;

}
