package com.nocountry.ecommerce.domain.model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", updatable = true, unique = true, nullable = false)
    private String name;

    @Column(name = "price", updatable = true, nullable = false, precision = 3)
    private Double price;

    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "detail", nullable = false)
    private String detail;

    @Column(name = "image", nullable = false, updatable = true)
    private String image;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!id.equals(product.id)) return false;
        if (!name.equals(product.name)) return false;
        if (!price.equals(product.price)) return false;
        if (!detail.equals(product.detail)) return false;
        return image.equals(product.image);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
