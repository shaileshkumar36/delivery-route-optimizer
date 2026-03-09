package com.shailesh.routeoptimizer.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RouteHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double totalDistance;

    private double fuelCost;

    private double estimatedTime;

    private LocalDateTime createdAt;

    public RouteHistory() {}

    public RouteHistory(double totalDistance, double fuelCost, double estimatedTime) {
        this.totalDistance = totalDistance;
        this.fuelCost = fuelCost;
        this.estimatedTime = estimatedTime;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}