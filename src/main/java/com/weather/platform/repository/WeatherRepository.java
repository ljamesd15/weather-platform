package com.weather.platform.repository;

import com.weather.platform.model.dao.WeatherDataDao;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import lombok.NonNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface WeatherRepository extends MongoRepository<WeatherDataDao, String> {

    WeatherDataDao save(@NonNull WeatherDataDao weatherData);

    void deleteById(@NonNull String id);

    Optional<WeatherDataDao> findById(@NonNull String id);

    List<WeatherDataDao> findAll();

    @Query("{'sensorMetadata.sensorId' : {$regex : ?0},"
            + " 'sensorMetadata.location' : {$regex : ?1},"
            + " 'time' : {$gte : ?2, $lt : ?3}}")
    List<WeatherDataDao> findByIdLocationTime(String sensorId,
                                              String sensorLocation,
                                              Instant minTime,
                                              Instant maxTime);
}
