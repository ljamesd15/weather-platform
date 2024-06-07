package com.weather.platform.mapper;

import com.weather.model.external.WeatherData;
import com.weather.platform.model.dao.WeatherDataDao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {SensorMetadataMapper.class, DateMappingUtils.class})
public interface WeatherDataMapper {

    WeatherDataDao dtoToDao(WeatherData weatherData);

    WeatherData daoToDto(WeatherDataDao dao);
}
