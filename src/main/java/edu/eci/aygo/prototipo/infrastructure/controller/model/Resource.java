package edu.eci.aygo.prototipo.infrastructure.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class Resource {
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Properties")
    Map<String, Object> propertiesDetails;
}
