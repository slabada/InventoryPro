package org.inventorypro.mapper;

import org.inventorypro.dto.LocationDto;
import org.inventorypro.dto.ProductDto;
import org.inventorypro.model.LocationModel;
import org.inventorypro.model.ProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationModel toModel(LocationDto locationDto);
    LocationDto toDto(LocationModel locationModel);
    @Mapping(target = "id", ignore = true)
    LocationModel update(LocationDto oldLocation, @MappingTarget LocationModel newLocation);
}
