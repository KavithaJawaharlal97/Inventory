package com.inventory.product.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

/*
 * This is a custom end point class to create custom-health endpoint
 */
@Component
@Endpoint(id="custom-health",enableByDefault = true)
public class CustomEndpoint {

    @ReadOperation
    public CustomHealth health() {
        Map<String, Object> details = new LinkedHashMap<String, Object>();
        details.put("CustomHealthStatus", "custom Health monitoring is activated");
        CustomHealth health = new CustomHealth();
        health.setHealthDetails(details);
        return health;
    }

    @ReadOperation
    public String customEndPointByName(@Selector String name) {
        return "custom-end-point";
    }
}
