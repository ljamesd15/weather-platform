package com.weather.platform.mapper;

import com.weather.platform.model.dao.WeatherDataDao;
import com.weather.platform.model.dto.WeatherDataDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {SensorMetadataMapper.class, DateMappingUtils.class})
public interface WeatherDataMapper {

    WeatherDataDao dtoToDao(WeatherDataDto dto);

    WeatherDataDto daoToDto(WeatherDataDao dao);
}
