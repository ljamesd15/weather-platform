package com.weather.platform.model.dao;

import java.util.List;
import lombok.Builder;

@Builder
public record SensorMetadataDao(
        Double longitude,
        Double latitude,
        String sensorId,
        List<String> tags,
        String location
) {}
