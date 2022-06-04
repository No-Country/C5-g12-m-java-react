package com.nocountry.ecommerce.domain.usecase;

import com.nocountry.ecommerce.domain.model.Product;
import com.nocountry.ecommerce.domain.model.User;
import com.nocountry.ecommerce.ports.input.rs.request.ProductFilterRequest;
import com.nocountry.ecommerce.ports.input.rs.response.ProductDetails;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService extends ActiveAvailable {

    Page<Product> pageOfProduct(ProductFilterRequest request);

    void save(Product product);

    Long create(Product product);

    void update(Long id, Product product);

    void delete(Long id);

    Product getByIdIfExist(Long id);
}
