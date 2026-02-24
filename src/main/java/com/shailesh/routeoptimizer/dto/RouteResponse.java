package com.shailesh.routeoptimizer.dto;

import com.shailesh.routeoptimizer.entity.Location;

import java.util.List;

public class RouteResponse {

    private List<Location> route;
    private double totalDistance;
    private double fuelCost;
    private double estimatedTime;

    public RouteResponse(List<Location> route,
                         double totalDistance,
                         double fuelCost,
                         double estimatedTime) {
        this.route = route;
        this.totalDistance = totalDistance;
        this.fuelCost = fuelCost;
        this.estimatedTime = estimatedTime;
    }

    public List<Location> getRoute() {
        return route;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public double getEstimatedTime() {
        return estimatedTime;
    }
}