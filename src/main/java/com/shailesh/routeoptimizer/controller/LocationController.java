package com.shailesh.routeoptimizer.controller;

import com.shailesh.routeoptimizer.entity.Location;
import com.shailesh.routeoptimizer.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    // Add Location
    @PostMapping
    public Location addLocation(@RequestBody Location location) {
        return locationRepository.save(location);
    }

    // Get All Locations
    @GetMapping
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}