package com.weather.platform.model.request;

import java.time.ZonedDateTime;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SearchWeatherDataRequest {
    private final String sensorId;
    private final String location;
    private final ZonedDateTime minTime;
    private final ZonedDateTime maxTime;
}
