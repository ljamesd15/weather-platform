package com.weather.platform.fixtures;

import com.weather.platform.model.dao.SensorMetadataDao;
import com.weather.platform.model.dto.SensorMetadataDto;

public interface SensorMetadataFixtures {

    double TEST_LATITUDE = 12.2;
    double TEST_LONGITUDE = 34.1;
    String TEST_SENSOR_NAME = "Sensor1";

    SensorMetadataDto TEST_SENSOR_METADATA_DTO = SensorMetadataDto.builder()
            .latitude(TEST_LATITUDE)
            .longitude(TEST_LONGITUDE)
            .name(TEST_SENSOR_NAME)
            .build();

    SensorMetadataDao TEST_SENSOR_METADATA_DAO = SensorMetadataDao.builder()
            .latitude(TEST_SENSOR_METADATA_DTO.getLatitude())
            .longitude(TEST_SENSOR_METADATA_DTO.getLongitude())
            .name(TEST_SENSOR_METADATA_DTO.getName())
            .build();
}
