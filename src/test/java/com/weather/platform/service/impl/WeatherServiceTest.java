package com.weather.platform.service.impl;

import com.weather.platform.mapper.WeatherDataMapper;
import com.weather.platform.model.dao.WeatherDataDao;
import com.weather.platform.model.dto.WeatherDataDto;
import com.weather.platform.repository.WeatherRepository;
import com.weather.platform.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.weather.platform.fixtures.WeatherDataFixtures.TEST_WEATHER_DATA_DAO;
import static com.weather.platform.fixtures.WeatherDataFixtures.TEST_WEATHER_DATA_DTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class WeatherServiceTest {

    @Autowired private WeatherDataMapper weatherDataMapper;

    @Mock private WeatherRepository weatherRepository;

    @Test
    public void getWeatherDataTest_withNoResults() {
        when(weatherRepository.findAll()).thenReturn(List.of());

        WeatherService underTest = new WeatherServiceImpl(weatherRepository, weatherDataMapper);
        List<WeatherDataDto> result = underTest.getWeatherData();
        assertTrue(result.isEmpty());
    }

    @Test
    public void getWeatherDataTest_withResults() {
        when(weatherRepository.findAll()).thenReturn(List.of(TEST_WEATHER_DATA_DAO));

        WeatherService underTest = new WeatherServiceImpl(weatherRepository, weatherDataMapper);
        List<WeatherDataDto> result = underTest.getWeatherData();
        assertEquals(1, result.size());
        assertTrue(result.contains(TEST_WEATHER_DATA_DTO));
    }

    @Test
    public void saveWeatherDataTest() {
        when(weatherRepository.save(any(WeatherDataDao.class))).thenReturn(TEST_WEATHER_DATA_DAO);

        WeatherService underTest = new WeatherServiceImpl(weatherRepository, weatherDataMapper);
        WeatherDataDto result = underTest.saveWeatherData(TEST_WEATHER_DATA_DTO);
        assertEquals(TEST_WEATHER_DATA_DTO, result);
    }

}
