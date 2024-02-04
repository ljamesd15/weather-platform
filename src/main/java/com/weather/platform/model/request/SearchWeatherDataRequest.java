package com.weather.platform.model.request;

import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;

@Builder
@Data
public class SearchWeatherDataRequest {
    public String sensorName;
    public ZonedDateTime from;
    public ZonedDateTime to;
}
