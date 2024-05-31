package org.inventorypro.mapper;

import api.dto.LocationDto;
import org.inventorypro.model.LocationModel;
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
