package com.weather.platform.fixtures;

import com.weather.platform.model.dao.WeatherDataDao;
import com.weather.platform.model.dto.WeatherDataDto;
import com.weather.platform.model.enums.Direction;

import java.time.ZoneId;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import static com.weather.platform.fixtures.SensorMetadataFixtures.TEST_SENSOR_METADATA_DAO;
import static com.weather.platform.fixtures.SensorMetadataFixtures.TEST_SENSOR_METADATA_DTO;
import static java.time.ZoneOffset.UTC;

public interface WeatherDataFixtures {
    ZonedDateTime TEST_ZONED_TIME = ZonedDateTime.of(2024, 1, 31, 12, 10, 8, 6, UTC);
    LocalDateTime TEST_LOCAL_TIME = TEST_ZONED_TIME.toLocalDateTime();
    double TEST_HUMIDITY = 61.6;
    double TEST_TEMPERATURE = 25.9;
    double TEST_LUX = 2.1;
    double TEST_WIND_SPEED = 5.7;

    WeatherDataDto TEST_WEATHER_DATA_DTO = WeatherDataDto.builder()
            .time(TEST_ZONED_TIME)
            .humidity(TEST_HUMIDITY)
            .temperature(TEST_TEMPERATURE)
            .lux(TEST_LUX)
            .windDirection(Direction.N)
            .windSpeed(TEST_WIND_SPEED)
            .sensorMetadata(TEST_SENSOR_METADATA_DTO)
            .build();

    WeatherDataDao TEST_WEATHER_DATA_DAO = WeatherDataDao.builder()
            .time(TEST_LOCAL_TIME)
            .humidity(TEST_WEATHER_DATA_DTO.getHumidity())
            .temperature(TEST_WEATHER_DATA_DTO.getTemperature())
            .lux(TEST_WEATHER_DATA_DTO.getLux())
            .windDirection(TEST_WEATHER_DATA_DTO.getWindDirection())
            .windSpeed(TEST_WEATHER_DATA_DTO.getWindSpeed())
            .sensorMetadata(TEST_SENSOR_METADATA_DAO)
            .build();
}
