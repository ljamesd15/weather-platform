package com.weather.platform.model.dao;

import com.weather.model.external.enums.Direction;
import java.time.Instant;
import lombok.Builder;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection = "weather")
public record WeatherDataDao(
        ObjectId id,
        Instant time,
        Double temperature,
        Double pressure,
        Double humidity,
        Double windSpeed,
        Double luminosity,
        Double uvIndex,
        Direction windDirection,
        SensorMetadataDao sensorMetadata
) {}
