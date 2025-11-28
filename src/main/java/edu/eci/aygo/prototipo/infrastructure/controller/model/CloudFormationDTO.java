package edu.eci.aygo.prototipo.infrastructure.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class CloudFormationDTO {
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Resources")
    private Map<String, Resource> resources;
}
