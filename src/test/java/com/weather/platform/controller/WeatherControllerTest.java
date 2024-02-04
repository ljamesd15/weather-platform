package com.weather.platform.controller;

import com.weather.platform.model.request.SearchWeatherDataRequest;
import com.weather.platform.model.request.SaveWeatherDataRequest;
import com.weather.platform.model.response.SearchWeatherDataResponse;
import com.weather.platform.model.response.SaveWeatherDataResponse;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherControllerTest {

    @Test
    public void searchWeatherDataTest() {
        SearchWeatherDataResponse expected = SearchWeatherDataResponse.builder().weatherDataDtoList(List.of()).build();

        WeatherController underTest = new WeatherController();
        SearchWeatherDataResponse actual = underTest.searchWeatherData(SearchWeatherDataRequest.builder().build());
        assertEquals(expected, actual);
    }


    @Test
    public void saveWeatherDataTest() {
        SaveWeatherDataResponse expected = SaveWeatherDataResponse.builder().build();

        WeatherController underTest = new WeatherController();
        SaveWeatherDataResponse actual = underTest.saveWeatherData(SaveWeatherDataRequest.builder().build());
        assertEquals(expected, actual);
    }
}
