package com.weather.platform.service.impl;

import com.weather.platform.mapper.WeatherDataMapper;
import com.weather.platform.model.dao.WeatherDataDao;
import com.weather.platform.model.dto.WeatherDataDto;
import com.weather.platform.repository.WeatherRepository;
import com.weather.platform.service.WeatherService;
import com.weather.platform.utils.MongoHelper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.ZoneId;
import java.util.List;

import static com.weather.platform.fixtures.WeatherDataFixtures.TEST_WEATHER_DATA_DAO;
import static com.weather.platform.fixtures.WeatherDataFixtures.TEST_WEATHER_DATA_DTO;
import static com.weather.platform.utils.MongoHelper.MAX_MONGO_TIME;
import static com.weather.platform.utils.MongoHelper.MIN_MONGO_TIME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class WeatherServiceTest {

    @Autowired private WeatherDataMapper weatherDataMapper;

    @Mock private WeatherRepository weatherRepository;

    @Test
    public void getWeatherDataTest_withNoResults() {
        when(weatherRepository.findAll()).thenReturn(List.of());

        WeatherService underTest = new WeatherServiceImpl(weatherRepository, weatherDataMapper, new MongoHelper());
        List<WeatherDataDto> result = underTest.getWeatherData();
        assertTrue(result.isEmpty());
    }

    @Test
    public void getWeatherDataTest_withResults() {
        when(weatherRepository.findAll()).thenReturn(List.of(TEST_WEATHER_DATA_DAO));

        WeatherService underTest = new WeatherServiceImpl(weatherRepository, weatherDataMapper, new MongoHelper());
        List<WeatherDataDto> result = underTest.getWeatherData();
        assertEquals(1, result.size());
        assertTrue(result.contains(TEST_WEATHER_DATA_DTO));
    }


    @Test
    public void searchWeatherDataTest_withNoResults() {
        MongoHelper mongoHelper = new MongoHelper();
        Instant min = Instant.now().minusSeconds(100);
        Instant max = Instant.now().plusSeconds(100);
        String sensorId = "test";
        String sensorLocation  = "test2";
        when(weatherRepository.findByIdLocationTime(
                mongoHelper.prefixSearchForString(sensorId),
                mongoHelper.prefixSearchForString(sensorLocation),
                min,
                max
        )).thenReturn(List.of());

        WeatherService underTest = new WeatherServiceImpl(weatherRepository, weatherDataMapper, mongoHelper);
        List<WeatherDataDto> result = underTest.searchWeatherData(
                sensorId,
                sensorLocation,
                min.atZone(ZoneId.of("UTC")),
                max.atZone(ZoneId.of("UTC"))
        );
        assertTrue(result.isEmpty());
    }

    @Test
    public void searchWeatherDataTest_withNullQuery() {
        MongoHelper mongoHelper = new MongoHelper();
        when(weatherRepository.findByIdLocationTime(
                mongoHelper.prefixSearchForString(null),
                mongoHelper.prefixSearchForString(null),
                MIN_MONGO_TIME,
                MAX_MONGO_TIME
        )).thenReturn(List.of());

        WeatherService underTest = new WeatherServiceImpl(weatherRepository, weatherDataMapper, mongoHelper);
        List<WeatherDataDto> result = underTest.searchWeatherData(null, null, null, null);
        assertTrue(result.isEmpty());
    }

    @Test
    public void searchWeatherDataTest_withResults() {
        MongoHelper mongoHelper = new MongoHelper();
        Instant min = Instant.now().minusSeconds(100);
        Instant max = Instant.now().plusSeconds(100);
        String sensorId = "test";
        String sensorLocation  = "test2";
        when(weatherRepository.findByIdLocationTime(
                mongoHelper.prefixSearchForString(null),
                mongoHelper.prefixSearchForString(null),
                MIN_MONGO_TIME,
                MAX_MONGO_TIME
        )).thenReturn(List.of(TEST_WEATHER_DATA_DAO));

        WeatherService underTest = new WeatherServiceImpl(weatherRepository, weatherDataMapper, mongoHelper);
        List<WeatherDataDto> result = underTest.searchWeatherData(null, null, null, null);
        assertEquals(1, result.size());
        assertTrue(result.contains(TEST_WEATHER_DATA_DTO));
    }

    @Test
    public void saveWeatherDataTest() {
        when(weatherRepository.save(any(WeatherDataDao.class))).thenReturn(TEST_WEATHER_DATA_DAO);

        WeatherService underTest = new WeatherServiceImpl(weatherRepository, weatherDataMapper, new MongoHelper());
        WeatherDataDto result = underTest.saveWeatherData(TEST_WEATHER_DATA_DTO);
        assertEquals(TEST_WEATHER_DATA_DTO, result);
    }

}
