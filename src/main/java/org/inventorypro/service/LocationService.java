package org.inventorypro.service;

import lombok.RequiredArgsConstructor;
import org.inventorypro.repository.LocationRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;



}
