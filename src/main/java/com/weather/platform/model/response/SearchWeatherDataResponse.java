package com.weather.platform.model.response;

import com.weather.platform.model.dto.WeatherDataDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class SearchWeatherDataResponse {
    private List<WeatherDataDto> weatherDataDtoList;
}
