package com.inventory.product.controller;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;

/*
 * This is a class to set & get the message for custom endpoint
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CustomHealth {

    private Map<String, Object> healthDetails;

    @JsonAnyGetter
    public Map<String, Object> getHealthDetails() {
        return this.healthDetails;
    }
    @JsonAnySetter
    public void setHealthDetails(Map<String, Object> details) {
        this.healthDetails=details;
    }
}