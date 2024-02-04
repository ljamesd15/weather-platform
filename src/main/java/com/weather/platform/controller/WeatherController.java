package com.weather.platform.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    public WeatherController() {}

    @GetMapping("/weatherData")
    public String getWeatherData() {
        return "Hello world";
    }
}
