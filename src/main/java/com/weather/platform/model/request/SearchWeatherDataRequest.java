package com.weather.platform.model.request;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SearchWeatherDataRequest {
    public final String sensorName;
    public final LocalDateTime from;
    public final LocalDateTime to;
}
