package com.weather.platform.model.request;

import com.weather.platform.model.dto.WeatherDataDto;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@Data
public class SaveWeatherDataRequest {
    private final WeatherDataDto weatherData;
}
