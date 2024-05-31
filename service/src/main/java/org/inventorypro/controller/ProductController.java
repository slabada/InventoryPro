package org.inventorypro.controller;

import api.controller.ProductControllerApi;
import api.dto.ProductDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.inventorypro.service.ProductService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ProductController implements ProductControllerApi {

    private final ProductService productService;

    @Override
    @QueryMapping(name = "getProduct")
    public ProductDto get(@Argument("id") @Min(1) Long id) {
        return productService.get(id);
    }

    @Override
    @MutationMapping(name = "saveProduct")
    public ProductDto save(@Argument("dto") @Valid ProductDto dto) {
        return productService.save(dto);
    }

    @Override
    @MutationMapping(name = "updateProduct")
    public ProductDto update(@Argument("id") @Min(1) Long id, @Argument("dto") @Valid ProductDto dto) {
        return productService.update(id, dto);
    }

    @Override
    @MutationMapping(name = "deleteProduct")
    public Long delete(@Argument("id") @Min(1) Long id) {
        return productService.delete(id);
    }
}
