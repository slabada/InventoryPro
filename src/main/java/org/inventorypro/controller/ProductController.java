package org.inventorypro.controller;

import lombok.RequiredArgsConstructor;
import org.inventorypro.dto.ProductDto;
import org.inventorypro.model.ProductModel;
import org.inventorypro.service.ProductService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @QueryMapping(name = "getProduct")
    public ProductDto get(@Argument long id) {
        return productService.get(id);
    }

    @MutationMapping(name = "saveProduct")
    public ProductDto save(@Argument ProductDto dto) {
        return productService.save(dto);
    }
}
