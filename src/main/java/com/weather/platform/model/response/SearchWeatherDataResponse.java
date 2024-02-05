package com.weather.platform.model.response;

import com.weather.platform.model.dto.WeatherDataDto;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class SearchWeatherDataResponse {
    private List<WeatherDataDto> weatherDataList;
}
