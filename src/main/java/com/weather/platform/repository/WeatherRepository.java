package com.weather.platform.repository;

import com.weather.platform.model.dao.WeatherDataDao;
import lombok.NonNull;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WeatherRepository extends MongoRepository<WeatherDataDao, String> {

    WeatherDataDao save(@NonNull WeatherDataDao weatherData);

    List<WeatherDataDao> findAll();
}
