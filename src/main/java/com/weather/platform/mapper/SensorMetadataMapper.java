package com.weather.platform.mapper;

import com.weather.platform.model.dao.SensorMetadataDao;
import com.weather.platform.model.dto.SensorMetadataDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SensorMetadataMapper {

    SensorMetadataDao dtoToDao(SensorMetadataDto dto);

    SensorMetadataDto daoToDto(SensorMetadataDao dao);
}
