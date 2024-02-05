package com.weather.platform.model.request;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class SearchWeatherDataRequest {
    public String sensorName;
    public LocalDateTime from;
    public LocalDateTime to;
}
