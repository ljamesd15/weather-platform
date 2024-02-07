package com.weather.platform.model.dao;

import com.weather.platform.model.enums.Direction;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document(collection = "weather")
public class WeatherDataDao {
    private final LocalDateTime time;
    private final Double temperature;
    private final Double pressure;
    private final Double humidity;
    private final Double windSpeed;
    private final Double luminosity;
    private final Double uvIndex;
    private final Direction windDirection;
    private final SensorMetadataDao sensorMetadata;
}
