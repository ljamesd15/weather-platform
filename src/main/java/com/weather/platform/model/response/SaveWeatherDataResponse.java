package com.weather.platform.model.response;

import com.weather.platform.model.dto.WeatherDataDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class SaveWeatherDataResponse {
    private WeatherDataDto weatherData;
}
