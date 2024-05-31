package org.inventorypro.controller;

import api.controller.LocationControllerApi;
import api.dto.LocationDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.inventorypro.service.LocationService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class LocationController implements LocationControllerApi {

    private final LocationService locationService;

    @Override
    @QueryMapping(name = "getLocation")
    public LocationDto get(@Argument @Min(1) Long id) {
        return locationService.get(id);
    }

    @Override
    @MutationMapping(name = "saveLocation")
    public LocationDto save(@Argument @Valid LocationDto dto) {
        return locationService.save(dto);
    }

    @Override
    @MutationMapping(name = "updateLocation")
    public LocationDto update(@Argument @Min(1) Long id, @Argument @Valid LocationDto dto) {
        return locationService.update(id, dto);
    }

    @Override
    @MutationMapping(name = "deleteLocation")
    public Long delete(@Argument @Min(1) Long id) {
        return locationService.delete(id);
    }
}
