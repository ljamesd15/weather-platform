package com.weather.platform.fixtures;

import com.weather.model.external.WeatherData;
import com.weather.model.external.enums.Direction;
import com.weather.model.external.request.SaveWeatherDataRequest;
import com.weather.platform.model.dao.WeatherDataDao;
import org.bson.types.ObjectId;

import java.time.Instant;
import java.time.ZonedDateTime;

import static com.weather.platform.fixtures.SensorMetadataFixtures.TEST_SENSOR_METADATA_DAO;
import static com.weather.platform.fixtures.SensorMetadataFixtures.TEST_SENSOR_METADATA;
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
    ObjectId TEST_OBJECT_ID = ObjectId.get();

    SaveWeatherDataRequest SAVE_WEATHER_DATA_REQUEST = SaveWeatherDataRequest.builder()
            .time(TEST_ZONED_TIME)
            .humidity(TEST_HUMIDITY)
            .pressure(TEST_PRESSURE)
            .temperature(TEST_TEMPERATURE)
            .luminosity(TEST_LUMINOSITY)
            .uvIndex(TEST_UV_INDEX)
            .windDirection(Direction.N)
            .windSpeed(TEST_WIND_SPEED)
            .sensorMetadata(TEST_SENSOR_METADATA)
            .build();

    WeatherData TEST_WEATHER_DATA = WeatherData.builder()
            .id(TEST_OBJECT_ID.toHexString())
            .time(TEST_ZONED_TIME)
            .humidity(TEST_HUMIDITY)
            .pressure(TEST_PRESSURE)
            .temperature(TEST_TEMPERATURE)
            .luminosity(TEST_LUMINOSITY)
            .uvIndex(TEST_UV_INDEX)
            .windDirection(Direction.N)
            .windSpeed(TEST_WIND_SPEED)
            .sensorMetadata(TEST_SENSOR_METADATA)
            .build();

    WeatherDataDao TEST_WEATHER_DATA_DAO = WeatherDataDao.builder()
            .id(TEST_OBJECT_ID)
            .time(TEST_INSTANT_TIME)
            .humidity(TEST_WEATHER_DATA.humidity())
            .pressure(TEST_WEATHER_DATA.pressure())
            .temperature(TEST_WEATHER_DATA.temperature())
            .luminosity(TEST_WEATHER_DATA.luminosity())
            .uvIndex(TEST_WEATHER_DATA.uvIndex())
            .windDirection(TEST_WEATHER_DATA.windDirection())
            .windSpeed(TEST_WEATHER_DATA.windSpeed())
            .sensorMetadata(TEST_SENSOR_METADATA_DAO)
            .build();
}
