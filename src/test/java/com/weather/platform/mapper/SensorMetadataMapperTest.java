package com.weather.platform.mapper;

import com.weather.model.external.SensorMetadata;
import com.weather.platform.model.dao.SensorMetadataDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.weather.platform.fixtures.SensorMetadataFixtures.TEST_SENSOR_METADATA_DAO;
import static com.weather.platform.fixtures.SensorMetadataFixtures.TEST_SENSOR_METADATA;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SensorMetadataMapperTest {

    @Autowired SensorMetadataMapper sensorMetadataMapper;

    @Test
    public void daoToDtoTest() {
        SensorMetadata sensorMetadata = sensorMetadataMapper.daoToDto(TEST_SENSOR_METADATA_DAO);
        assertEquals(TEST_SENSOR_METADATA_DAO.getLatitude(), sensorMetadata.latitude());
        assertEquals(TEST_SENSOR_METADATA_DAO.getLongitude(), sensorMetadata.longitude());
        assertEquals(TEST_SENSOR_METADATA_DAO.getSensorId(), sensorMetadata.sensorId());
        assertEquals(TEST_SENSOR_METADATA_DAO.getLocation(), sensorMetadata.location());
        assertEquals(TEST_SENSOR_METADATA_DAO.getTags(), sensorMetadata.tags());
    }

    @Test
    public void dtoToDaoTest() {
        SensorMetadataDao dao = sensorMetadataMapper.dtoToDao(TEST_SENSOR_METADATA);
        assertEquals(TEST_SENSOR_METADATA.latitude(), dao.getLatitude());
        assertEquals(TEST_SENSOR_METADATA.longitude(), dao.getLongitude());
        assertEquals(TEST_SENSOR_METADATA.sensorId(), dao.getSensorId());
        assertEquals(TEST_SENSOR_METADATA.location(), dao.getLocation());
        assertEquals(TEST_SENSOR_METADATA.tags(), dao.getTags());
    }
}
