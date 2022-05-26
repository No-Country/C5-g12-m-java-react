package com.nocountry.ecommerce.ports.input.rs.mapper;

import com.nocountry.ecommerce.domain.model.Product;
import com.nocountry.ecommerce.ports.input.rs.request.CreateProductRequest;
import com.nocountry.ecommerce.ports.input.rs.request.UpdateProductRequest;
import com.nocountry.ecommerce.ports.input.rs.response.ProductDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

   @Mapping(source = "mark", target = "mark.id")
   @Mapping(source = "category", target = "category.id")
   Product CreateProductToProduct(CreateProductRequest request);

   Product UpdateProductToProduct(UpdateProductRequest request);

   ProductDetails ProductToProductDetails(Product product);

   List<ProductDetails> ProductListToProductDetailList(List<Product> list);


}
