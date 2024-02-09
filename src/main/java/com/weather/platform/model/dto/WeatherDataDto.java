package com.weather.platform.model.dto;

import com.weather.platform.model.enums.Direction;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
public class WeatherDataDto {
    /** Time the weather data was captured. */
    private final ZonedDateTime time;

    /** Temperature measured in Celsius. */
    private final Double temperature;

    /** Pressure measured in millibars. */
    private final Double pressure;

    /** Humidity of the air, 1-100%. */
    private final Double humidity;

    /** Speed of the wind in kilometers per hour. */
    private final Double windSpeed;

    /** Direction of the wind. */
    private final Direction windDirection;

    /** Level of illuminance measured in lux. */
    private final Double luminosity;

    /** UV Index, 0-11+. */
    private final Double uvIndex;

    /** Metadata of the sensor sending the weather data. */
    private final SensorMetadataDto sensorMetadata;
}
