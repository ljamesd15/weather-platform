package com.weather.platform.model.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.springframework.lang.NonNull;

@Builder
@Data
public class SensorMetadataDto {
    private final Double longitude;
    private final Double latitude;
    @NonNull
    private final String id;
    private final List<String> tags;
    @NonNull
    private final String location;
}
