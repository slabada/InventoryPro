package org.inventorypro.mapper;

import org.inventorypro.dto.ProductDto;
import org.inventorypro.model.ProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.TargetType;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductModel toModel(ProductDto productDto);
    ProductDto toDto(ProductModel productModel);
    @Mapping(target = "id", ignore = true)
    ProductModel update(ProductDto oldProduct, @MappingTarget ProductModel newProduct);
}
