package com.shailesh.routeoptimizer.service;

import org.springframework.stereotype.Service;

@Service
public class DistanceService {

    public double calculateDistance(double lat1, double lon1,
                                    double lat2, double lon2) {

        double x = lat2 - lat1;
        double y = lon2 - lon1;

        return Math.sqrt(x * x + y * y);
    }
}