package api.controller;

import api.dto.LocationDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

public interface LocationControllerApi {
    @QueryMapping(name = "getLocation")
    LocationDto get(@Argument("id") @Min(1) Long id);
    @MutationMapping(name = "saveLocation")
    LocationDto save(@Argument("dto") @Valid LocationDto dto);
    @MutationMapping(name = "updateLocation")
    LocationDto update(@Argument("id") @Min(1) Long id, @Argument("dto") @Valid LocationDto dto);
    @MutationMapping(name = "deleteLocation")
    Long delete(@Argument("id") @Min(1) Long id);
}
