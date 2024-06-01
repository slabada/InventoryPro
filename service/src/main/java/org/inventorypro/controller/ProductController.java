package org.inventorypro.controller;

import api.controller.ProductControllerApi;
import api.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.inventorypro.service.ProductService;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ProductController implements ProductControllerApi {

    private final ProductService productService;

    @Override
    public ProductDto get(Long id) {
        return productService.get(id);
    }

    @Override
    public ProductDto save(ProductDto dto) {
        return productService.save(dto);
    }

    @Override
    public ProductDto update(Long id, ProductDto dto) {
        return productService.update(id, dto);
    }

    @Override
    public Long delete(Long id) {
        return productService.delete(id);
    }
}
