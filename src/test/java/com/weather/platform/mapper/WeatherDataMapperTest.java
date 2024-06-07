package com.weather.platform.mapper;

import com.weather.model.external.WeatherData;
import com.weather.platform.model.dao.WeatherDataDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.weather.platform.fixtures.WeatherDataFixtures.TEST_WEATHER_DATA_DAO;
import static com.weather.platform.fixtures.WeatherDataFixtures.TEST_WEATHER_DATA;
import static java.time.ZoneOffset.UTC;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WeatherDataMapperTest {

    @Autowired
    WeatherDataMapper weatherDataMapper;

    @Test
    public void daoToDtoTest() {
        WeatherData weatherData = weatherDataMapper.daoToDto(TEST_WEATHER_DATA_DAO);
        assertEquals(TEST_WEATHER_DATA_DAO.humidity(), weatherData.humidity());
        assertEquals(TEST_WEATHER_DATA_DAO.luminosity(), weatherData.luminosity());
        assertEquals(TEST_WEATHER_DATA_DAO.uvIndex(), weatherData.uvIndex());
        assertEquals(TEST_WEATHER_DATA_DAO.pressure(), weatherData.pressure());
        assertEquals(TEST_WEATHER_DATA_DAO.time().atZone(UTC), weatherData.time());
        assertEquals(TEST_WEATHER_DATA_DAO.windSpeed(), weatherData.windSpeed());
        assertEquals(TEST_WEATHER_DATA_DAO.windDirection(), weatherData.windDirection());
        assertEquals(TEST_WEATHER_DATA_DAO.temperature(), weatherData.temperature());
        assertEquals(TEST_WEATHER_DATA_DAO.sensorMetadata().sensorId(), weatherData.sensorMetadata().sensorId());
        assertEquals(TEST_WEATHER_DATA_DAO.sensorMetadata().longitude(), weatherData.sensorMetadata().longitude());
        assertEquals(TEST_WEATHER_DATA_DAO.sensorMetadata().latitude(), weatherData.sensorMetadata().latitude());
    }

    @Test
    public void dtoToDaoTest() {
        WeatherDataDao dao = weatherDataMapper.dtoToDao(TEST_WEATHER_DATA);
        assertEquals(TEST_WEATHER_DATA.humidity(), dao.humidity());
        assertEquals(TEST_WEATHER_DATA.luminosity(), dao.luminosity());
        assertEquals(TEST_WEATHER_DATA.uvIndex(), dao.uvIndex());
        assertEquals(TEST_WEATHER_DATA.pressure(), dao.pressure());
        assertEquals(TEST_WEATHER_DATA.time(), dao.time().atZone(UTC));
        assertEquals(TEST_WEATHER_DATA.windSpeed(), dao.windSpeed());
        assertEquals(TEST_WEATHER_DATA.windDirection(), dao.windDirection());
        assertEquals(TEST_WEATHER_DATA.temperature(), dao.temperature());
        assertEquals(TEST_WEATHER_DATA.sensorMetadata().sensorId(), dao.sensorMetadata().sensorId());
        assertEquals(TEST_WEATHER_DATA.sensorMetadata().longitude(), dao.sensorMetadata().longitude());
        assertEquals(TEST_WEATHER_DATA.sensorMetadata().latitude(), dao.sensorMetadata().latitude());
    }
}
