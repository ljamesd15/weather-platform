package com.weather.platform.service;

import com.weather.platform.model.dto.WeatherDataDto;
import java.time.ZonedDateTime;
import java.util.List;

public interface WeatherService {

    // TODO: Support filtering
    List<WeatherDataDto> getWeatherData();

    List<WeatherDataDto> searchWeatherData(String sensorId,
                                           String sensorLocation,
                                           ZonedDateTime minTime,
                                           ZonedDateTime maxTime);

    WeatherDataDto saveWeatherData(WeatherDataDto toSave);
}
