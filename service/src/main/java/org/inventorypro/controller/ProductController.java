package org.inventorypro.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.inventorypro.dto.ProductDto;
import org.inventorypro.model.ProductModel;
import org.inventorypro.service.ProductService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @QueryMapping(name = "getProduct")
    public ProductDto get(@Argument @Min(1) Long id) {
        return productService.get(id);
    }

    @MutationMapping(name = "saveProduct")
    public ProductDto save(@Argument @Valid ProductDto dto) {
        return productService.save(dto);
    }

    @MutationMapping(name = "updateProduct")
    public ProductDto update(@Argument @Min(1) Long id, @Argument @Valid ProductDto dto) {
        return productService.update(id, dto);
    }

    @MutationMapping(name = "deleteProduct")
    public Long delete(@Argument @Min(1) Long id) {
        return productService.delete(id);
    }
}
