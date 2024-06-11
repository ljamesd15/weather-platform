package com.weather.platform.controller;

import com.weather.model.external.WeatherData;
import com.weather.model.external.request.SaveWeatherDataRequest;
import com.weather.model.external.request.SearchWeatherDataRequest;
import com.weather.model.external.response.SaveWeatherDataResponse;
import com.weather.model.external.response.SearchWeatherDataResponse;
import com.weather.platform.service.WeatherService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
        final List<WeatherData> weatherDataList = this.weatherService.searchWeatherData(request.sensorId(),
                request.location(),
                request.minTime(),
                request.maxTime());
        return SearchWeatherDataResponse.builder().weatherDataList(weatherDataList).build();
    }

    @PostMapping("/saveWeatherData")
    public SaveWeatherDataResponse saveWeatherData(@RequestBody SaveWeatherDataRequest request) {
        final WeatherData saved = this.weatherService.saveWeatherData(request);
        return SaveWeatherDataResponse.builder().weatherData(saved).build();
    }

    @DeleteMapping("/deleteWeatherData")
    public ResponseEntity<Void> deleteWeatherData(@RequestParam String id) {
        try {
            this.weatherService.deleteWeatherData(id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
