package org.inventorypro.service;

import lombok.RequiredArgsConstructor;
import org.inventorypro.dto.ProductDto;
import org.inventorypro.mapper.ProductMapper;
import org.inventorypro.model.ProductModel;
import org.inventorypro.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper mapper;

    public ProductDto get(long id){
        Optional<ProductModel> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new RuntimeException("Продукт не найден");
        }
        return mapper.toDto(product.get());
    }

    public ProductDto save(ProductDto productDto){
        ProductModel model = mapper.toModel(productDto);
        ProductModel save = productRepository.save(model);
        return mapper.toDto(save);
    }
}
