package com.weather.platform.model.dao;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SensorMetadataDao {
    private final double longitude;
    private final double latitude;
    private final String name;
}
