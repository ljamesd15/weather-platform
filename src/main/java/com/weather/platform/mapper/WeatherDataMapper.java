package com.weather.platform.mapper;

import com.weather.model.external.WeatherData;
import com.weather.platform.model.dao.WeatherDataDao;
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {SensorMetadataMapper.class, DateMappingUtils.class})
public interface WeatherDataMapper {

    @Mapping(source = "id", target = "id", qualifiedByName = "stringToObjectId")
    WeatherDataDao dtoToDao(WeatherData weatherData);

    @Mapping(source = "id", target = "id", qualifiedByName = "objectIdToString")
    WeatherData daoToDto(WeatherDataDao dao);

    @Named("objectIdToString")
    static String objectIdToString(ObjectId id) {
        return id.toHexString();
    }

    @Named("stringToObjectId")
    static ObjectId stringToObjectId(String id) {
        return new ObjectId(id);
    }
}
