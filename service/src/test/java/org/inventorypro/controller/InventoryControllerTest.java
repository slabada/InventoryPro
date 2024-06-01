package org.inventorypro.controller;

import api.dto.InventoryDto;
import api.dto.LocationDto;
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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource("/application-test.properties")
@AutoConfigureGraphQlTester
@Import(GraphqlConfiguration.class)
class InventoryControllerTest {

    @Autowired
    GraphQlTester graphQlTester;

    @Test
    @Order(0)
    void get() {
        String query = """
                query {
                  getInventory(id:1){
                    id
                    product{
                      id
                      name
                      description
                      price
                    }
                    location{
                      id
                      sector
                      wardrobe
                      shelf
                    }
                    quantity
                  }
                }
                """;

        var product = new ProductDto(4,"testName_inventory", "testDescription_inventory", BigDecimal.valueOf(123));
        var location = new LocationDto(4, "testSector_inventory", "testWardrobe_inventory", "testShelf_inventory");
        var inventory = new InventoryDto(1,product, location, 123);

        graphQlTester.document(query)
                .execute()
                .path("getInventory")
                .entity(InventoryDto.class)
                .isEqualTo(inventory);
    }

    @Test
    @Order(1)
    void save() {
        String query = """
                mutation {
                  saveInventory(dto:{
                    product:{
                      id:4
                    }
                    location:{
                      id:4
                    }
                    quantity:123
                  }){
                    id
                    product{
                      id
                      name
                      description
                      price
                    }
                    location{
                      id
                      sector
                      wardrobe
                      shelf
                    }
                    quantity
                  }
                }
                """;

        var product = new ProductDto(4,"testName_inventory", "testDescription_inventory", BigDecimal.valueOf(123));
        var location = new LocationDto(4, "testSector_inventory", "testWardrobe_inventory", "testShelf_inventory");
        var inventory = new InventoryDto(5,product, location, 123);

        var result = graphQlTester.document(query)
                .execute()
                .path("saveInventory")
                .entity(InventoryDto.class)
                .get();

        assertEquals(result, inventory);
    }

    @Test
    @Order(2)
    void update() {
        String query = """
                mutation {
                  updateInventory(id:2 dto:{
                    product:{
                      id:5
                    }
                    location:{
                      id:5
                    }
                    quantity:123
                  }){
                    id
                    product{
                      id
                      name
                      description
                      price
                    }
                    location{
                      id
                      sector
                      wardrobe
                      shelf
                    }
                    quantity
                  }
                }
                """;

        var product = new ProductDto(5,"testName_inventoryUpdate", "testDescription_inventoryUpdate", BigDecimal.valueOf(123));
        var location = new LocationDto(5, "testSector_inventoryUpdate", "testWardrobe_inventoryUpdate", "testShelf_inventoryUpdate");
        var inventory = new InventoryDto(2,product, location, 123);

        var result = graphQlTester.document(query)
                .execute()
                .path("updateInventory")
                .entity(InventoryDto.class)
                .get();

        assertEquals(result, inventory);
    }

    @Test
    @Order(3)
    void delete() {
        String query = """
                mutation {
                  deleteInventory(id:3)
                }
                """;
        var result = graphQlTester.document(query)
                .execute()
                .path("deleteInventory")
                .entity(Long.class)
                .get();
        assertEquals(result, 3);
    }
}