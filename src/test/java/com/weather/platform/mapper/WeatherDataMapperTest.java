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
        assertEquals(TEST_WEATHER_DATA_DAO.getHumidity(), weatherData.humidity());
        assertEquals(TEST_WEATHER_DATA_DAO.getLuminosity(), weatherData.luminosity());
        assertEquals(TEST_WEATHER_DATA_DAO.getUvIndex(), weatherData.uvIndex());
        assertEquals(TEST_WEATHER_DATA_DAO.getPressure(), weatherData.pressure());
        assertEquals(TEST_WEATHER_DATA_DAO.getTime().atZone(UTC), weatherData.time());
        assertEquals(TEST_WEATHER_DATA_DAO.getWindSpeed(), weatherData.windSpeed());
        assertEquals(TEST_WEATHER_DATA_DAO.getWindDirection(), weatherData.windDirection());
        assertEquals(TEST_WEATHER_DATA_DAO.getTemperature(), weatherData.temperature());
        assertEquals(TEST_WEATHER_DATA_DAO.getSensorMetadata().getSensorId(), weatherData.sensorMetadata().sensorId());
        assertEquals(TEST_WEATHER_DATA_DAO.getSensorMetadata().getLongitude(), weatherData.sensorMetadata().longitude());
        assertEquals(TEST_WEATHER_DATA_DAO.getSensorMetadata().getLatitude(), weatherData.sensorMetadata().latitude());
    }

    @Test
    public void dtoToDaoTest() {
        WeatherDataDao dao = weatherDataMapper.dtoToDao(TEST_WEATHER_DATA);
        assertEquals(TEST_WEATHER_DATA.humidity(), dao.getHumidity());
        assertEquals(TEST_WEATHER_DATA.luminosity(), dao.getLuminosity());
        assertEquals(TEST_WEATHER_DATA.uvIndex(), dao.getUvIndex());
        assertEquals(TEST_WEATHER_DATA.pressure(), dao.getPressure());
        assertEquals(TEST_WEATHER_DATA.time(), dao.getTime().atZone(UTC));
        assertEquals(TEST_WEATHER_DATA.windSpeed(), dao.getWindSpeed());
        assertEquals(TEST_WEATHER_DATA.windDirection(), dao.getWindDirection());
        assertEquals(TEST_WEATHER_DATA.temperature(), dao.getTemperature());
        assertEquals(TEST_WEATHER_DATA.sensorMetadata().sensorId(), dao.getSensorMetadata().getSensorId());
        assertEquals(TEST_WEATHER_DATA.sensorMetadata().longitude(), dao.getSensorMetadata().getLongitude());
        assertEquals(TEST_WEATHER_DATA.sensorMetadata().latitude(), dao.getSensorMetadata().getLatitude());
    }
}
