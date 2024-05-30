package org.inventorypro.mapper;

import org.inventorypro.dto.ProductDto;
import org.inventorypro.model.ProductModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductModel toModel(ProductDto productDto);
    ProductDto toDto(ProductModel productModel);
}
