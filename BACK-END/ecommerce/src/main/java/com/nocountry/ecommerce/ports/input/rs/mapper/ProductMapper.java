package com.nocountry.ecommerce.ports.input.rs.mapper;

import com.nocountry.ecommerce.domain.model.Product;
import com.nocountry.ecommerce.ports.input.rs.request.CreateProductRequest;
import com.nocountry.ecommerce.ports.input.rs.response.ProductDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

   ProductDetails ProductToProductDetails(Product aux);

   List<ProductDetails> ListProductToProductDetailList(List<Product> list);

   @Mapping(source = "mark", target = "mark.id")
   @Mapping(source = "category", target = "category.id")
   Product CreateProductToProduct(CreateProductRequest aux);

}
