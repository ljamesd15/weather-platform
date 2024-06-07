package com.weather.platform.service;

import com.weather.model.external.WeatherData;
import java.time.ZonedDateTime;
import java.util.List;

public interface WeatherService {

    // TODO: Support filtering
    List<WeatherData> getWeatherData();

    List<WeatherData> searchWeatherData(String sensorId,
                                           String sensorLocation,
                                           ZonedDateTime minTime,
                                           ZonedDateTime maxTime);

    WeatherData saveWeatherData(WeatherData toSave);
}
