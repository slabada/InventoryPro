package api.controller;

import api.dto.ProductDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

public interface ProductControllerApi {
    @QueryMapping(name = "getProduct")
    ProductDto get(@Argument("id") @Min(1) Long id);
    @MutationMapping(name = "saveProduct")
    ProductDto save(@Argument("dto") @Valid ProductDto dto);
    @MutationMapping(name = "updateProduct")
    ProductDto update(@Argument("id") @Min(1) Long id, @Argument("dto") @Valid ProductDto dto);
    @MutationMapping(name = "deleteProduct")
    Long delete(@Argument("id") @Min(1) Long id);
}
