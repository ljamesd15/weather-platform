package com.weather.platform.model.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class SensorMetadataDto {
    private double longitude;
    private double latitude;
    private String id;
    private List<String> tags;
    private String location;
}
