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
    private final double temperature;
    private final double pressure;
    private final double humidity;
    private final double windSpeed;
    private final Direction windDirection;
    private final double lux;
    private final SensorMetadataDao sensorMetadata;
}
