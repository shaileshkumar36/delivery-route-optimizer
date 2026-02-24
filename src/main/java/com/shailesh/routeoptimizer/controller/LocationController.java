package com.shailesh.routeoptimizer.controller;

import com.shailesh.routeoptimizer.dto.RouteResponse;
import com.shailesh.routeoptimizer.entity.Location;
import com.shailesh.routeoptimizer.repository.LocationRepository;
import com.shailesh.routeoptimizer.service.DistanceService;
import org.springframework.web.bind.annotation.*;
import com.shailesh.routeoptimizer.service.RouteService;
import com.shailesh.routeoptimizer.dto.RouteResponse;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final LocationRepository locationRepository;
    private final DistanceService distanceService;
    private final RouteService routeService;

    public LocationController(LocationRepository locationRepository,
                              DistanceService distanceService,
                              RouteService routeService) {
        this.locationRepository = locationRepository;
        this.distanceService = distanceService;
        this.routeService = routeService;
    }

    @PostMapping
    public Location addLocation(@RequestBody Location location) {
        return locationRepository.save(location);
    }

    @GetMapping
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @GetMapping("/test-distance")
    public double testDistance() {
        return distanceService.calculateDistance(10, 20, 15, 25);
    }

    @GetMapping("/optimize")
    public RouteResponse optimizeRoute() {
        return routeService.optimizeRoute();
    }
}