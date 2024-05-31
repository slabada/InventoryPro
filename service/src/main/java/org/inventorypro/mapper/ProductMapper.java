package org.inventorypro.mapper;

import api.dto.ProductDto;
import org.inventorypro.model.ProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductModel toModel(ProductDto productDto);
    ProductDto toDto(ProductModel productModel);
    @Mapping(target = "id", ignore = true)
    ProductModel update(ProductDto oldProduct, @MappingTarget ProductModel newProduct);
}
