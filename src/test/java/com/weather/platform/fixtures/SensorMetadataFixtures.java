package com.weather.platform.fixtures;

import com.weather.model.external.SensorMetadata;
import com.weather.platform.model.dao.SensorMetadataDao;
import java.util.List;

public interface SensorMetadataFixtures {

    double TEST_LATITUDE = 12.2;
    double TEST_LONGITUDE = 34.1;
    String TEST_SENSOR_ID = "Sensor1";
    String TEST_TAG_1 = "Tag1";
    String TEST_TAG_2 = "Tag2";
    String TEST_LOCATION = "Greenhouse";

    SensorMetadata TEST_SENSOR_METADATA = SensorMetadata.builder()
            .latitude(TEST_LATITUDE)
            .longitude(TEST_LONGITUDE)
            .sensorId(TEST_SENSOR_ID)
            .tags(List.of(TEST_TAG_1, TEST_TAG_2))
            .location(TEST_LOCATION)
            .build();

    SensorMetadataDao TEST_SENSOR_METADATA_DAO = SensorMetadataDao.builder()
            .latitude(TEST_SENSOR_METADATA.latitude())
            .longitude(TEST_SENSOR_METADATA.longitude())
            .sensorId(TEST_SENSOR_METADATA.sensorId())
            .tags(TEST_SENSOR_METADATA.tags())
            .location(TEST_SENSOR_METADATA.location())
            .build();
}
