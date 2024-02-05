package com.weather.platform.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class SearchWeatherDataRequest {
    public String sensorName;
    public LocalDateTime from;
    public LocalDateTime to;
}
