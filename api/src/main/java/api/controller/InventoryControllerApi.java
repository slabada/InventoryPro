package api.controller;

import api.dto.InventoryDto;
import jakarta.validation.constraints.Min;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

public interface InventoryControllerApi {
    @QueryMapping(name = "getInventory")
    InventoryDto get(@Argument("id") @Min(1) Long id);
    @MutationMapping(name = "saveInventory")
    InventoryDto save(@Argument("dto") InventoryDto dto);
    @MutationMapping(name = "updateInventory")
    InventoryDto update(@Argument("id") @Min(1) Long id, @Argument("dto") InventoryDto dto);
    @MutationMapping(name = "deleteInventory")
    Long delete(@Argument("id") @Min(1) Long id);
}
