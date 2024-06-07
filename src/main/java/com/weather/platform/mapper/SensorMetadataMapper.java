package com.weather.platform.mapper;

import com.weather.model.external.SensorMetadata;
import com.weather.platform.model.dao.SensorMetadataDao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SensorMetadataMapper {

    SensorMetadataDao dtoToDao(SensorMetadata sensorMetadata);

    SensorMetadata daoToDto(SensorMetadataDao dao);
}
