package org.inventorypro.service;

import api.dto.LocationDto;
import lombok.RequiredArgsConstructor;
import org.inventorypro.exception.LocationException;
import org.inventorypro.mapper.LocationMapper;
import org.inventorypro.model.LocationModel;
import org.inventorypro.repository.LocationRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    private final LocationMapper mapper;

    public LocationDto get(Long id){
        LocationModel location = locationRepository.findById(id)
                .orElseThrow(() -> new LocationException("Локация не найдена"));
        return mapper.toDto(location);
    }

    public LocationDto save(LocationDto locationDto){
        LocationModel model = mapper.toModel(locationDto);
        LocationModel saveModel = locationRepository.save(model);
        return mapper.toDto(saveModel);
    }

    public LocationDto update(Long id, LocationDto locationDto){
        LocationModel location = locationRepository.findById(id)
                .orElseThrow(() -> new LocationException("Продукт не найден"));
        LocationModel model = mapper.update(locationDto, location);
        locationRepository.save(model);
        return mapper.toDto(model);
    }

    public Long delete(Long id){
        boolean exists = locationRepository.existsById(id);
        if(!exists){
            throw new LocationException("Продукт не найден");
        }
        locationRepository.deleteById(id);
        return id;
    }
}
