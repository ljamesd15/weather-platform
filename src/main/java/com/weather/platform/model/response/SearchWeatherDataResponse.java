package com.weather.platform.model.response;

import com.weather.platform.model.dto.WeatherDataDto;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SearchWeatherDataResponse {
    private final List<WeatherDataDto> weatherDataList;
}
