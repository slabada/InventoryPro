package org.inventorypro.controller;

import api.controller.InventoryControllerApi;
import api.dto.InventoryDto;
import lombok.RequiredArgsConstructor;
import org.inventorypro.service.InventoryService;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class InventoryController implements InventoryControllerApi {

    private final InventoryService inventoryService;

    @Override
    public InventoryDto get(Long id) {
        return inventoryService.get(id);
    }

    @Override
    public InventoryDto save(InventoryDto dto) {
        return inventoryService.save(dto);
    }

    @Override
    public InventoryDto update(Long id, InventoryDto dto) {
        return inventoryService.update(id, dto);
    }

    @Override
    public Long delete(Long id) {
        return inventoryService.delete(id);
    }
}
