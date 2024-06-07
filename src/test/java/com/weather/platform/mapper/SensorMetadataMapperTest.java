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
        assertEquals(TEST_SENSOR_METADATA_DAO.latitude(), sensorMetadata.latitude());
        assertEquals(TEST_SENSOR_METADATA_DAO.longitude(), sensorMetadata.longitude());
        assertEquals(TEST_SENSOR_METADATA_DAO.sensorId(), sensorMetadata.sensorId());
        assertEquals(TEST_SENSOR_METADATA_DAO.location(), sensorMetadata.location());
        assertEquals(TEST_SENSOR_METADATA_DAO.tags(), sensorMetadata.tags());
    }

    @Test
    public void dtoToDaoTest() {
        SensorMetadataDao dao = sensorMetadataMapper.dtoToDao(TEST_SENSOR_METADATA);
        assertEquals(TEST_SENSOR_METADATA.latitude(), dao.latitude());
        assertEquals(TEST_SENSOR_METADATA.longitude(), dao.longitude());
        assertEquals(TEST_SENSOR_METADATA.sensorId(), dao.sensorId());
        assertEquals(TEST_SENSOR_METADATA.location(), dao.location());
        assertEquals(TEST_SENSOR_METADATA.tags(), dao.tags());
    }
}
