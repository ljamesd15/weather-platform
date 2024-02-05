package com.weather.platform.model.request;

import com.weather.platform.model.dto.WeatherDataDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class SaveWeatherDataRequest {
    private WeatherDataDto weatherData;
}
