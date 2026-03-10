package com.shailesh.routeoptimizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class)
public class RouteoptimizerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RouteoptimizerApplication.class, args);
    }

}