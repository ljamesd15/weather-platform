package com.weather.platform.fixtures;

import com.weather.platform.model.dao.WeatherDataDao;
import com.weather.platform.model.dto.WeatherDataDto;
import com.weather.platform.model.enums.Direction;

import java.time.Instant;
import java.time.ZonedDateTime;

import static com.weather.platform.fixtures.SensorMetadataFixtures.TEST_SENSOR_METADATA_DAO;
import static com.weather.platform.fixtures.SensorMetadataFixtures.TEST_SENSOR_METADATA_DTO;
import static java.time.ZoneOffset.UTC;

public interface WeatherDataFixtures {
    ZonedDateTime TEST_ZONED_TIME = ZonedDateTime.of(2024, 1, 31, 12, 10, 8, 6, UTC);
    Instant TEST_INSTANT_TIME = TEST_ZONED_TIME.toInstant();
    double TEST_HUMIDITY = 61.6;
    double TEST_PRESSURE = 1024;
    double TEST_TEMPERATURE = 25.9;
    double TEST_LUMINOSITY = 12000;
    double TEST_UV_INDEX = 5.2;
    double TEST_WIND_SPEED = 5.7;

    WeatherDataDto TEST_WEATHER_DATA_DTO = WeatherDataDto.builder()
            .time(TEST_ZONED_TIME)
            .humidity(TEST_HUMIDITY)
            .pressure(TEST_PRESSURE)
            .temperature(TEST_TEMPERATURE)
            .luminosity(TEST_LUMINOSITY)
            .uvIndex(TEST_UV_INDEX)
            .windDirection(Direction.N)
            .windSpeed(TEST_WIND_SPEED)
            .sensorMetadata(TEST_SENSOR_METADATA_DTO)
            .build();

    WeatherDataDao TEST_WEATHER_DATA_DAO = WeatherDataDao.builder()
            .time(TEST_INSTANT_TIME)
            .humidity(TEST_WEATHER_DATA_DTO.getHumidity())
            .pressure(TEST_WEATHER_DATA_DTO.getPressure())
            .temperature(TEST_WEATHER_DATA_DTO.getTemperature())
            .luminosity(TEST_WEATHER_DATA_DTO.getLuminosity())
            .uvIndex(TEST_WEATHER_DATA_DTO.getUvIndex())
            .windDirection(TEST_WEATHER_DATA_DTO.getWindDirection())
            .windSpeed(TEST_WEATHER_DATA_DTO.getWindSpeed())
            .sensorMetadata(TEST_SENSOR_METADATA_DAO)
            .build();
}
