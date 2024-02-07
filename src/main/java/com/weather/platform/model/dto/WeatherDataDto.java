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
    /** Time the weather data was captured. */
    private ZonedDateTime time;

    /** Temperature measured in Celsius. */
    private Double temperature;

    /** Pressure measured in millibars. */
    private Double pressure;

    /** Humidity of the air, 1-100%. */
    private Double humidity;

    /** Speed of the wind in kilometers per hour. */
    private Double windSpeed;

    /** Direction of the wind. */
    private Direction windDirection;

    /** Level of illuminance measured in lux. */
    private Double luminosity;

    /** UV Index, 0-11+. */
    private Double uvIndex;

    /** Metadata of the sensor sending the weather data. */
    private SensorMetadataDto sensorMetadata;
}
