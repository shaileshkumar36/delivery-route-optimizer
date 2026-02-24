package com.shailesh.routeoptimizer.service;

import com.shailesh.routeoptimizer.dto.RouteResponse;
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

    public RouteResponse optimizeRoute() {

        List<Location> locations = locationRepository.findAll();

        if (locations.isEmpty()) {
            return new RouteResponse(new ArrayList<>(), 0, 0, 0);
        }

        List<Location> optimizedRoute = new ArrayList<>();
        List<Location> unvisited = new ArrayList<>(locations);

        Location current = unvisited.remove(0);
        optimizedRoute.add(current);
        double totalDistance = 0;
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

            totalDistance += shortestDistance;
            current = nearest;
            optimizedRoute.add(current);
            unvisited.remove(current);
        }

        // Assume:
        double fuelPerKm = 5;      // ₹5 per km
        double avgSpeed = 40;      // 40 km/h

        double fuelCost = totalDistance * fuelPerKm;
        double estimatedTime = totalDistance / avgSpeed;

        return new RouteResponse(
                optimizedRoute,
                totalDistance,
                fuelCost,
                estimatedTime
        );
    }
}