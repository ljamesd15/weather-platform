package com.weather.platform.controller;

import com.weather.platform.model.request.SearchWeatherDataRequest;
import com.weather.platform.model.request.SaveWeatherDataRequest;
import com.weather.platform.model.response.SearchWeatherDataResponse;
import com.weather.platform.model.response.SaveWeatherDataResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WeatherController {

    public WeatherController() {}

    @PostMapping("/searchWeatherData")
    public SearchWeatherDataResponse searchWeatherData(@RequestBody SearchWeatherDataRequest request) {
        return SearchWeatherDataResponse.builder().weatherDataList(List.of()).build();
    }

    @PostMapping("/saveWeatherData")
    public SaveWeatherDataResponse saveWeatherData(@RequestBody SaveWeatherDataRequest request) {
        return SaveWeatherDataResponse.builder().build();
    }
}
