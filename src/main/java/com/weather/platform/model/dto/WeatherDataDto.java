package com.weather.platform.model.dto;

import com.weather.platform.model.enums.Direction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class WeatherDataDto {
    private ZonedDateTime time;
    private double temperature;
    private double humidity;
    private double windSpeed;
    private Direction windDirection;
    private double lux;
    private SensorMetadataDto sensorMetadata;
}
