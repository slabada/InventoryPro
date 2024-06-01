package org.inventorypro.controller;

import api.dto.LocationDto;
import org.inventorypro.configuration.GraphqlConfiguration;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.graphql.test.tester.GraphQlTester;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource("/application-test.properties")
@AutoConfigureGraphQlTester
@Import(GraphqlConfiguration.class)
class LocationControllerTest {

    @Autowired
    GraphQlTester graphQlTester;

    @Test
    @Order(0)
    void get() {
        String query = """
                query getLocation {
                   getLocation(id: 1) {
                        id
                        sector
                        wardrobe
                        shelf
                    }
                }
                """;
        graphQlTester.document(query)
                .execute()
                .path("getLocation")
                .entity(LocationDto.class)
                .isEqualTo(new LocationDto(1, "testSector", "testWardrobe", "testShelf"));
    }

    @Test
    @Order(1)
    void save() {
        String query = """
                mutation {
                  saveLocation(dto:{
                    sector:"testSector"
                    wardrobe:"testWardrobe"
                    shelf:"testShelf"
                  }){
                    id
                    sector
                    wardrobe
                    shelf
                  }
                }
                """;
        var result = graphQlTester.document(query)
                .execute()
                .path("saveLocation")
                .entity(LocationDto.class)
                .get();
        assertEquals(result, new LocationDto(6, "testSector", "testWardrobe", "testShelf"));
    }

    @Test
    @Order(2)
    void update() {
        String query = """
                mutation {
                  updateLocation(id:2 dto:{
                    sector:"testSector"
                    wardrobe:"testWardrobe"
                    shelf:"testShelf"
                  }){
                    id
                    sector
                    wardrobe
                    shelf
                  }
                }
                """;
        var result = graphQlTester.document(query)
                .execute()
                .path("updateLocation")
                .entity(LocationDto.class)
                .get();
        assertEquals(result, new LocationDto(2, "testSector", "testWardrobe", "testShelf"));
    }

    @Test
    @Order(3)
    void delete() {
        String query = """
                mutation {
                  deleteLocation(id:3)
                }
                """;
        var result = graphQlTester.document(query)
                .execute()
                .path("deleteLocation")
                .entity(Long.class)
                .get();
        assertEquals(result, 3);
    }
}