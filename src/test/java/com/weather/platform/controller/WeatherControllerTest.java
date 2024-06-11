package com.weather.platform.controller;

import com.weather.model.external.request.SearchWeatherDataRequest;
import com.weather.model.external.response.SaveWeatherDataResponse;
import com.weather.model.external.response.SearchWeatherDataResponse;
import com.weather.platform.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.weather.platform.fixtures.WeatherDataFixtures.SAVE_WEATHER_DATA_REQUEST;
import static com.weather.platform.fixtures.WeatherDataFixtures.TEST_OBJECT_ID;
import static com.weather.platform.fixtures.WeatherDataFixtures.TEST_WEATHER_DATA;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@SpringBootTest
public class WeatherControllerTest {

    @Mock
    private WeatherService weatherService;

    @InjectMocks
    private WeatherController underTest;

    @Test
    public void searchWeatherDataTest_withEmptyList() {
        SearchWeatherDataResponse expected = SearchWeatherDataResponse.builder().weatherDataList(List.of()).build();
        when(weatherService.searchWeatherData(null, null, null, null)).thenReturn(List.of());

        SearchWeatherDataResponse actual = underTest.searchWeatherData(SearchWeatherDataRequest.builder().build());
        assertEquals(expected, actual);
    }

    @Test
    public void searchWeatherDataTest() {
        SearchWeatherDataResponse expected = SearchWeatherDataResponse.builder().weatherDataList(List.of(TEST_WEATHER_DATA)).build();
        when(weatherService.searchWeatherData(null, null, null, null)).thenReturn(List.of(TEST_WEATHER_DATA));

        SearchWeatherDataResponse actual = underTest.searchWeatherData(SearchWeatherDataRequest.builder().build());
        assertEquals(expected, actual);
    }


    @Test
    public void saveWeatherDataTest() {
        SaveWeatherDataResponse expected = SaveWeatherDataResponse.builder()
                .weatherData(TEST_WEATHER_DATA).build();
        when(weatherService.saveWeatherData(SAVE_WEATHER_DATA_REQUEST)).thenReturn(TEST_WEATHER_DATA);

        SaveWeatherDataResponse actual = underTest.saveWeatherData(SAVE_WEATHER_DATA_REQUEST);
        assertEquals(expected, actual);
    }

    @Test
    public void deleteWeatherDataTest() {
        doNothing().when(weatherService).deleteWeatherData(TEST_OBJECT_ID.toHexString());

        ResponseEntity<Void> response = underTest.deleteWeatherData(TEST_OBJECT_ID.toHexString());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void deleteWeatherDataTest_whenNoIdFound() {
        doThrow(new IllegalArgumentException("Sample ex")).when(weatherService)
                .deleteWeatherData(TEST_OBJECT_ID.toHexString());

        ResponseEntity<Void> response = underTest.deleteWeatherData(TEST_OBJECT_ID.toHexString());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
