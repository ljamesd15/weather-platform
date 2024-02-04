package com.weather.platform.model.dao;

import com.weather.platform.model.enums.Direction;
import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;

@Builder
@Data
public class WeatherDataDao {
    private final ZonedDateTime time;
    private final double temperature;
    private final double humidity;
    private final double windSpeed;
    private final Direction windDirection;
    private final double lux;
    private final SensorMetadataDao sensorMetadata;
}
