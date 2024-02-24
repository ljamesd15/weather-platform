package com.weather.platform.model.dao;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SensorMetadataDao {
    private final Double longitude;
    private final Double latitude;
    private final String sensorId;
    private final List<String> tags;
    private final String location;
}
