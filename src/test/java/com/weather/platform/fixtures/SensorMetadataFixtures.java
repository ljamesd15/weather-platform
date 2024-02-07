package com.weather.platform.fixtures;

import com.weather.platform.model.dao.SensorMetadataDao;
import com.weather.platform.model.dto.SensorMetadataDto;
import java.util.List;

public interface SensorMetadataFixtures {

    double TEST_LATITUDE = 12.2;
    double TEST_LONGITUDE = 34.1;
    String TEST_SENSOR_ID = "Sensor1";
    String TEST_TAG_1 = "Tag1";
    String TEST_TAG_2 = "Tag2";
    String TEST_LOCATION = "Greenhouse";

    SensorMetadataDto TEST_SENSOR_METADATA_DTO = SensorMetadataDto.builder()
            .latitude(TEST_LATITUDE)
            .longitude(TEST_LONGITUDE)
            .id(TEST_SENSOR_ID)
            .tags(List.of(TEST_TAG_1, TEST_TAG_2))
            .location(TEST_LOCATION)
            .build();

    SensorMetadataDao TEST_SENSOR_METADATA_DAO = SensorMetadataDao.builder()
            .latitude(TEST_SENSOR_METADATA_DTO.getLatitude())
            .longitude(TEST_SENSOR_METADATA_DTO.getLongitude())
            .id(TEST_SENSOR_METADATA_DTO.getId())
            .tags(TEST_SENSOR_METADATA_DTO.getTags())
            .location(TEST_SENSOR_METADATA_DTO.getLocation())
            .build();
}
