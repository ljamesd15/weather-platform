package com.weather.platform.service.impl;

import com.weather.model.external.WeatherData;
import com.weather.platform.mapper.WeatherDataMapper;
import com.weather.platform.model.dao.WeatherDataDao;
import com.weather.platform.repository.WeatherRepository;
import com.weather.platform.service.WeatherService;
import com.weather.platform.utils.MongoHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static com.weather.platform.fixtures.WeatherDataFixtures.SAVE_WEATHER_DATA_REQUEST;
import static com.weather.platform.fixtures.WeatherDataFixtures.TEST_OBJECT_ID;
import static com.weather.platform.fixtures.WeatherDataFixtures.TEST_WEATHER_DATA_DAO;
import static com.weather.platform.fixtures.WeatherDataFixtures.TEST_WEATHER_DATA;
import static com.weather.platform.utils.MongoHelper.MAX_MONGO_TIME;
import static com.weather.platform.utils.MongoHelper.MIN_MONGO_TIME;
import static java.time.ZoneOffset.UTC;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class WeatherServiceTest {

    @Autowired private WeatherDataMapper weatherDataMapper;
    @Autowired private MongoHelper mongoHelper;
    @Mock private WeatherRepository weatherRepository;

    private WeatherServiceImpl underTest;

    @BeforeEach
    public void setup() {
        this.underTest = new WeatherServiceImpl(weatherRepository, weatherDataMapper, mongoHelper);
    }

    @Test
    public void getWeatherDataTest_withNoResults() {
        when(weatherRepository.findAll()).thenReturn(List.of());

        List<WeatherData> result = underTest.getWeatherData();
        assertTrue(result.isEmpty());
    }

    @Test
    public void getWeatherDataTest_withResults() {
        when(weatherRepository.findAll()).thenReturn(List.of(TEST_WEATHER_DATA_DAO));

        List<WeatherData> result = underTest.getWeatherData();
        assertEquals(1, result.size());
        assertTrue(result.contains(TEST_WEATHER_DATA));
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

        List<WeatherData> result = underTest.searchWeatherData(
                sensorId,
                sensorLocation,
                min.atZone(UTC),
                max.atZone(UTC)
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

        List<WeatherData> result = underTest.searchWeatherData(null, null, null, null);
        assertTrue(result.isEmpty());
    }

    @Test
    public void searchWeatherDataTest_withResults() {
        MongoHelper mongoHelper = new MongoHelper();
        when(weatherRepository.findByIdLocationTime(
                mongoHelper.prefixSearchForString(null),
                mongoHelper.prefixSearchForString(null),
                MIN_MONGO_TIME,
                MAX_MONGO_TIME
        )).thenReturn(List.of(TEST_WEATHER_DATA_DAO));

        List<WeatherData> result = underTest.searchWeatherData(null, null, null, null);
        assertEquals(1, result.size());
        assertTrue(result.contains(TEST_WEATHER_DATA));
    }

    @Test
    public void saveWeatherDataTest() {
        when(weatherRepository.save(any(WeatherDataDao.class))).thenReturn(TEST_WEATHER_DATA_DAO);

        WeatherData result = underTest.saveWeatherData(SAVE_WEATHER_DATA_REQUEST);
        assertEquals(TEST_WEATHER_DATA, result);
    }

    @Test
    public void deleteWeatherDataTest() {
        when(weatherRepository.findById(TEST_OBJECT_ID.toHexString())).thenReturn(
                Optional.of(TEST_WEATHER_DATA_DAO)
        );

        underTest.deleteWeatherData(TEST_OBJECT_ID.toHexString());
    }

    @Test
    public void deleteWeatherDataTest_withNoFoundWeatherData() {
        when(weatherRepository.findById(TEST_OBJECT_ID.toHexString())).thenReturn(
                Optional.empty()
        );

        assertThrows(IllegalArgumentException.class,
                () -> underTest.deleteWeatherData(TEST_OBJECT_ID.toHexString())
        );
    }

}
