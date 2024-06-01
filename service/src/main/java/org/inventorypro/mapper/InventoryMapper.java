package org.inventorypro.mapper;

import api.dto.InventoryDto;
import org.inventorypro.model.InventoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface InventoryMapper {
    InventoryModel toModel(InventoryDto inventoryDto);
    InventoryDto toDto(InventoryModel inventoryModel);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "location", ignore = true)
    InventoryModel update(InventoryDto oldInventory, @MappingTarget InventoryModel newInventory);
}
