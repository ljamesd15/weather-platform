package com.weather.platform.service;

import com.weather.model.external.WeatherData;
import com.weather.model.external.request.SaveWeatherDataRequest;
import java.time.ZonedDateTime;
import java.util.List;

public interface WeatherService {

    // TODO: Support filtering
    List<WeatherData> getWeatherData();

    List<WeatherData> searchWeatherData(String sensorId,
                                           String sensorLocation,
                                           ZonedDateTime minTime,
                                           ZonedDateTime maxTime);

    WeatherData saveWeatherData(SaveWeatherDataRequest toSave);

    void deleteWeatherData(String id);
}
