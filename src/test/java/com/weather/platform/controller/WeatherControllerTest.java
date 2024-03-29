package com.weather.platform.controller;

import com.weather.platform.model.request.SearchWeatherDataRequest;
import com.weather.platform.model.request.SaveWeatherDataRequest;
import com.weather.platform.model.response.SearchWeatherDataResponse;
import com.weather.platform.model.response.SaveWeatherDataResponse;
import com.weather.platform.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.weather.platform.fixtures.WeatherDataFixtures.TEST_WEATHER_DATA_DTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class WeatherControllerTest {

    @Mock
    private WeatherService weatherService;

    @Test
    public void searchWeatherDataTest_withEmptyList() {
        SearchWeatherDataResponse expected = SearchWeatherDataResponse.builder().weatherDataList(List.of()).build();
        when(weatherService.searchWeatherData(null, null, null, null)).thenReturn(List.of());

        WeatherController underTest = new WeatherController(weatherService);
        SearchWeatherDataResponse actual = underTest.searchWeatherData(SearchWeatherDataRequest.builder().build());
        assertEquals(expected, actual);
    }

    @Test
    public void searchWeatherDataTest() {
        SearchWeatherDataResponse expected = SearchWeatherDataResponse.builder().weatherDataList(List.of(TEST_WEATHER_DATA_DTO)).build();
        when(weatherService.searchWeatherData(null, null, null, null)).thenReturn(List.of(TEST_WEATHER_DATA_DTO));

        WeatherController underTest = new WeatherController(weatherService);
        SearchWeatherDataResponse actual = underTest.searchWeatherData(SearchWeatherDataRequest.builder().build());
        assertEquals(expected, actual);
    }


    @Test
    public void saveWeatherDataTest() {
        SaveWeatherDataResponse expected = SaveWeatherDataResponse.builder()
                .weatherData(TEST_WEATHER_DATA_DTO).build();
        when(weatherService.saveWeatherData(TEST_WEATHER_DATA_DTO)).thenReturn(TEST_WEATHER_DATA_DTO);

        WeatherController underTest = new WeatherController(weatherService);
        SaveWeatherDataResponse actual = underTest.saveWeatherData(SaveWeatherDataRequest.builder()
                .weatherData(TEST_WEATHER_DATA_DTO).build());
        assertEquals(expected, actual);
    }
}
