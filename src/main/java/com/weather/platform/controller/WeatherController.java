package com.weather.platform.controller;

import com.weather.platform.model.dto.WeatherDataDto;
import com.weather.platform.model.request.SaveWeatherDataRequest;
import com.weather.platform.model.request.SearchWeatherDataRequest;
import com.weather.platform.model.response.SaveWeatherDataResponse;
import com.weather.platform.model.response.SearchWeatherDataResponse;
import com.weather.platform.service.WeatherService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(final WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping("/searchWeatherData")
    public SearchWeatherDataResponse searchWeatherData(@RequestBody SearchWeatherDataRequest request) {
        final List<WeatherDataDto> weatherDataList = this.weatherService.searchWeatherData(request.getSensorId(),
                request.getLocation(),
                request.getMinTime(),
                request.getMaxTime());
        return SearchWeatherDataResponse.builder().weatherDataList(weatherDataList).build();
    }

    @PostMapping("/saveWeatherData")
    public SaveWeatherDataResponse saveWeatherData(@RequestBody SaveWeatherDataRequest request) {
        final WeatherDataDto saved = this.weatherService.saveWeatherData(request.getWeatherData());
        return SaveWeatherDataResponse.builder().weatherData(saved).build();
    }
}
