package com.weather.platform.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.weather.platform.model.enums.Direction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class WeatherData {
    private ZonedDateTime time;
    private double temperature;
    private double humidity;
    private double windSpeed;
    private Direction windDirection;
    private double lux;
    private SensorMetadata sensorMetadata;
}
