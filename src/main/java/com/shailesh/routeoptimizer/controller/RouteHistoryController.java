package com.shailesh.routeoptimizer.controller;

import com.shailesh.routeoptimizer.entity.RouteHistory;
import com.shailesh.routeoptimizer.repository.RouteHistoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteHistoryController {

    private final RouteHistoryRepository routeHistoryRepository;

    public RouteHistoryController(RouteHistoryRepository routeHistoryRepository) {
        this.routeHistoryRepository = routeHistoryRepository;
    }

    @GetMapping("/history")
    public List<RouteHistory> getRouteHistory() {
        return routeHistoryRepository.findAll();
    }
}