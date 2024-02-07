package com.weather.platform.mapper;

import com.weather.platform.model.dao.WeatherDataDao;
import com.weather.platform.model.dto.WeatherDataDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.weather.platform.fixtures.WeatherDataFixtures.TEST_WEATHER_DATA_DAO;
import static com.weather.platform.fixtures.WeatherDataFixtures.TEST_WEATHER_DATA_DTO;
import static java.time.ZoneOffset.UTC;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WeatherDataMapperTest {

    @Autowired
    WeatherDataMapper weatherDataMapper;

    @Test
    public void daoToDtoTest() {
        WeatherDataDto dto = weatherDataMapper.daoToDto(TEST_WEATHER_DATA_DAO);
        assertEquals(TEST_WEATHER_DATA_DAO.getHumidity(), dto.getHumidity());
        assertEquals(TEST_WEATHER_DATA_DAO.getLux(), dto.getLux());
        assertEquals(TEST_WEATHER_DATA_DAO.getPressure(), dto.getPressure());
        assertEquals(TEST_WEATHER_DATA_DAO.getTime().atZone(UTC), dto.getTime());
        assertEquals(TEST_WEATHER_DATA_DAO.getWindSpeed(), dto.getWindSpeed());
        assertEquals(TEST_WEATHER_DATA_DAO.getWindDirection(), dto.getWindDirection());
        assertEquals(TEST_WEATHER_DATA_DAO.getTemperature(), dto.getTemperature());
        assertEquals(TEST_WEATHER_DATA_DAO.getSensorMetadata().getId(), dto.getSensorMetadata().getId());
        assertEquals(TEST_WEATHER_DATA_DAO.getSensorMetadata().getLongitude(), dto.getSensorMetadata().getLongitude());
        assertEquals(TEST_WEATHER_DATA_DAO.getSensorMetadata().getLatitude(), dto.getSensorMetadata().getLatitude());
    }

    @Test
    public void dtoToDaoTest() {
        WeatherDataDao dao = weatherDataMapper.dtoToDao(TEST_WEATHER_DATA_DTO);
        assertEquals(TEST_WEATHER_DATA_DTO.getHumidity(), dao.getHumidity());
        assertEquals(TEST_WEATHER_DATA_DTO.getLux(), dao.getLux());
        assertEquals(TEST_WEATHER_DATA_DTO.getPressure(), dao.getPressure());
        assertEquals(TEST_WEATHER_DATA_DTO.getTime(), dao.getTime().atZone(UTC));
        assertEquals(TEST_WEATHER_DATA_DTO.getWindSpeed(), dao.getWindSpeed());
        assertEquals(TEST_WEATHER_DATA_DTO.getWindDirection(), dao.getWindDirection());
        assertEquals(TEST_WEATHER_DATA_DTO.getTemperature(), dao.getTemperature());
        assertEquals(TEST_WEATHER_DATA_DTO.getSensorMetadata().getId(), dao.getSensorMetadata().getId());
        assertEquals(TEST_WEATHER_DATA_DTO.getSensorMetadata().getLongitude(), dao.getSensorMetadata().getLongitude());
        assertEquals(TEST_WEATHER_DATA_DTO.getSensorMetadata().getLatitude(), dao.getSensorMetadata().getLatitude());
    }
}
