package org.inventorypro.controller;

import api.dto.ProductDto;
import org.inventorypro.configuration.GraphqlConfiguration;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.graphql.test.tester.GraphQlTester;
import org.springframework.test.context.TestPropertySource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource("/application-test.properties")
@AutoConfigureGraphQlTester
@Import(GraphqlConfiguration.class)
class ProductControllerTest {

    @Autowired
    GraphQlTester graphQlTester;

    @Test
    @Order(0)
    void get() {
        String query = """
                query getProduct {
                   getProduct(id: 1) {
                        id
                        name
                        description
                        price
                    }
                }
                """;
        graphQlTester.document(query)
                .execute()
                .path("getProduct")
                .entity(ProductDto.class)
                .isEqualTo(new ProductDto(1, "testName","testDescription", BigDecimal.valueOf(123)));
    }

    @Test
    @Order(1)
    void save() {
        String query = """
                mutation {
                  saveProduct(dto:{
                    name:"testName"
                    description:"testDescription"
                    price:123
                  }){
                    id
                    name
                    description
                    price
                  }
                }
                """;
        var result = graphQlTester.document(query)
                .execute()
                .path("saveProduct")
                .entity(ProductDto.class)
                .get();
        assertEquals(result, new ProductDto(4, "testName","testDescription", BigDecimal.valueOf(123)));
    }

    @Test
    @Order(2)
    void update() {
        String query = """
                mutation {
                  updateProduct(id:2 dto:{
                    name:"testName"
                    description:"testDescription"
                    price:123
                  }){
                    id
                    name
                    description
                    price
                  }
                }
                """;
        var result = graphQlTester.document(query)
                .execute()
                .path("updateProduct")
                .entity(ProductDto.class)
                .get();
        assertEquals(result, new ProductDto(2, "testName","testDescription", BigDecimal.valueOf(123)));
    }

    @Test
    @Order(3)
    void delete() {
        String query = """
                mutation {
                  deleteProduct(id:3)
                }
                """;
        var result = graphQlTester.document(query)
                .execute()
                .path("deleteProduct")
                .entity(Long.class)
                .get();
        assertEquals(result, 3);
    }
}