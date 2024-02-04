package com.weather.platform.model.response;

import com.weather.platform.model.dto.WeatherData;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class SearchWeatherDataResponse {
    private final List<WeatherData> weatherDataList;
}
