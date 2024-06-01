package org.inventorypro.service;

import api.dto.InventoryDto;
import lombok.RequiredArgsConstructor;
import org.inventorypro.exception.InventoryException;
import org.inventorypro.exception.LocationException;
import org.inventorypro.exception.ProductException;
import org.inventorypro.mapper.InventoryMapper;
import org.inventorypro.model.InventoryModel;
import org.inventorypro.repository.InventoryRepository;
import org.inventorypro.repository.LocationRepository;
import org.inventorypro.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    private final LocationRepository locationRepository;

    private final ProductRepository productRepository;

    private final InventoryMapper inventoryMapper;

    public InventoryDto get(Long id){
        InventoryModel model = inventoryRepository.findById(id)
                .orElseThrow(() -> new InventoryException("Инвентарь не найден"));
        return inventoryMapper.toDto(model);
    }

    public InventoryDto save(InventoryDto inventoryDto){
        var product = productRepository.findById(inventoryDto.getProduct().getId())
                .orElseThrow(() -> new ProductException("Продукт не найден"));
        var location = locationRepository.findById(inventoryDto.getLocation().getId())
                .orElseThrow(() -> new LocationException("Локация не найдена"));
        InventoryModel model = inventoryMapper.toModel(inventoryDto);
        model.setProduct(product);
        model.setLocation(location);
        InventoryModel save = inventoryRepository.save(model);
        return inventoryMapper.toDto(save);
    }

    public InventoryDto update(Long id, InventoryDto inventoryDto){
        var product = productRepository.findById(inventoryDto.getProduct().getId())
                .orElseThrow(() -> new ProductException("Продукт не найден"));
        var location = locationRepository.findById(inventoryDto.getLocation().getId())
                .orElseThrow(() -> new LocationException("Локация не найдена"));
        InventoryModel inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new InventoryException("Инветарь не найден"));
        InventoryModel update = inventoryMapper.update(inventoryDto, inventory);
        update.setProduct(product);
        update.setLocation(location);
        inventoryRepository.save(update);
        return inventoryMapper.toDto(update);
    }

    public Long delete(Long id){
        if(!inventoryRepository.existsById(id)){
            throw new InventoryException("Инвентарь не найден");
        }
        inventoryRepository.deleteById(id);
        return id;
    }
}
