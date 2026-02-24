package com.shailesh.routeoptimizer.service;

import com.shailesh.routeoptimizer.entity.Location;
import com.shailesh.routeoptimizer.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteService {

    private final LocationRepository locationRepository;
    private final DistanceService distanceService;

    public RouteService(LocationRepository locationRepository,
                        DistanceService distanceService) {
        this.locationRepository = locationRepository;
        this.distanceService = distanceService;
    }

    public List<Location> optimizeRoute() {

        List<Location> locations = locationRepository.findAll();

        if (locations.isEmpty()) {
            return new ArrayList<>();
        }

        List<Location> optimizedRoute = new ArrayList<>();
        List<Location> unvisited = new ArrayList<>(locations);

        // Start from first location (warehouse)
        Location current = unvisited.remove(0);
        optimizedRoute.add(current);

        while (!unvisited.isEmpty()) {

            Location nearest = null;
            double shortestDistance = Double.MAX_VALUE;

            for (Location location : unvisited) {

                double distance = distanceService.calculateDistance(
                        current.getLatitude(),
                        current.getLongitude(),
                        location.getLatitude(),
                        location.getLongitude()
                );

                if (distance < shortestDistance) {
                    shortestDistance = distance;
                    nearest = location;
                }
            }

            current = nearest;
            optimizedRoute.add(current);
            unvisited.remove(current);
        }

        return optimizedRoute;
    }
}