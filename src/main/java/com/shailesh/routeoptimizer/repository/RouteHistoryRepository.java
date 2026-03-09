package com.shailesh.routeoptimizer.repository;

import com.shailesh.routeoptimizer.entity.RouteHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteHistoryRepository extends JpaRepository<RouteHistory, Long> {
}