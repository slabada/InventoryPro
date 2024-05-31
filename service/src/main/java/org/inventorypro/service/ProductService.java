package org.inventorypro.service;

import api.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.inventorypro.exception.ProductException;
import org.inventorypro.mapper.ProductMapper;
import org.inventorypro.model.ProductModel;
import org.inventorypro.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper mapper;

    public ProductDto get(Long id){
        ProductModel product = productRepository.findById(id)
                .orElseThrow(() -> new ProductException("Продукт не найден"));
        return mapper.toDto(product);
    }

    public ProductDto save(ProductDto productDto){
        ProductModel model = mapper.toModel(productDto);
        ProductModel saveModel = productRepository.save(model);
        return mapper.toDto(saveModel);
    }

    public ProductDto update(Long id, ProductDto productDto){
        ProductModel product = productRepository.findById(id)
                .orElseThrow(() -> new ProductException("Продукт не найден"));
        ProductModel model = mapper.update(productDto, product);
        productRepository.save(model);
        return mapper.toDto(model);
    }

    public Long delete(Long id){
        boolean exists = productRepository.existsById(id);
        if(!exists){
            throw new ProductException("Продукт не найден");
        }
        productRepository.deleteById(id);
        return id;
    }
}
