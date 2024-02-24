package com.weather.platform.mapper;

import com.weather.platform.model.dao.SensorMetadataDao;
import com.weather.platform.model.dto.SensorMetadataDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.weather.platform.fixtures.SensorMetadataFixtures.TEST_SENSOR_METADATA_DAO;
import static com.weather.platform.fixtures.SensorMetadataFixtures.TEST_SENSOR_METADATA_DTO;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SensorMetadataMapperTest {

    @Autowired SensorMetadataMapper sensorMetadataMapper;

    @Test
    public void daoToDtoTest() {
        SensorMetadataDto dto = sensorMetadataMapper.daoToDto(TEST_SENSOR_METADATA_DAO);
        assertEquals(TEST_SENSOR_METADATA_DAO.getLatitude(), dto.getLatitude());
        assertEquals(TEST_SENSOR_METADATA_DAO.getLongitude(), dto.getLongitude());
        assertEquals(TEST_SENSOR_METADATA_DAO.getSensorId(), dto.getSensorId());
        assertEquals(TEST_SENSOR_METADATA_DAO.getLocation(), dto.getLocation());
        assertEquals(TEST_SENSOR_METADATA_DAO.getTags(), dto.getTags());
    }

    @Test
    public void dtoToDaoTest() {
        SensorMetadataDao dao = sensorMetadataMapper.dtoToDao(TEST_SENSOR_METADATA_DTO);
        assertEquals(TEST_SENSOR_METADATA_DTO.getLatitude(), dao.getLatitude());
        assertEquals(TEST_SENSOR_METADATA_DTO.getLongitude(), dao.getLongitude());
        assertEquals(TEST_SENSOR_METADATA_DTO.getSensorId(), dao.getSensorId());
        assertEquals(TEST_SENSOR_METADATA_DTO.getLocation(), dao.getLocation());
        assertEquals(TEST_SENSOR_METADATA_DTO.getTags(), dao.getTags());
    }
}
