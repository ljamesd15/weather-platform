package com.weather.platform.service;

import com.weather.platform.model.dto.WeatherDataDto;

import java.util.List;

public interface WeatherService {

    // TODO: Support filtering
    List<WeatherDataDto> getWeatherData();
    WeatherDataDto saveWeatherData(WeatherDataDto toSave);
}
