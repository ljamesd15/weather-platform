package com.weather.platform.model.response;

import com.weather.platform.model.dto.WeatherDataDto;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SaveWeatherDataResponse {
    private final WeatherDataDto weatherData;
}
