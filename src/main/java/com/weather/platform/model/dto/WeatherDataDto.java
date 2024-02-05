package com.weather.platform.model.dto;

import com.weather.platform.model.enums.Direction;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
