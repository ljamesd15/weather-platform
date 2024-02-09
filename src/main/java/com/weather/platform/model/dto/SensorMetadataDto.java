package com.weather.platform.model.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SensorMetadataDto {
    private final Double longitude;
    private final Double latitude;
    private final String id;
    private final List<String> tags;
    private final String location;
}
