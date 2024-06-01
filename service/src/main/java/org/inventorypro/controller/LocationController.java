package org.inventorypro.controller;

import api.controller.LocationControllerApi;
import api.dto.LocationDto;
import lombok.RequiredArgsConstructor;
import org.inventorypro.service.LocationService;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class LocationController implements LocationControllerApi {

    private final LocationService locationService;

    @Override
    public LocationDto get(Long id) {
        return locationService.get(id);
    }

    @Override
    public LocationDto save(LocationDto dto) {
        return locationService.save(dto);
    }

    @Override
    public LocationDto update(Long id, LocationDto dto) {
        return locationService.update(id, dto);
    }

    @Override
    public Long delete(Long id) {
        return locationService.delete(id);
    }
}
