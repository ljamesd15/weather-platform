package com.weather.platform.service.impl;

import static com.weather.platform.utils.MongoHelper.MAX_MONGO_TIME;
import static com.weather.platform.utils.MongoHelper.MIN_MONGO_TIME;

import com.weather.platform.mapper.WeatherDataMapper;
import com.weather.platform.model.dao.WeatherDataDao;
import com.weather.platform.model.dto.WeatherDataDto;
import com.weather.platform.repository.WeatherRepository;
import com.weather.platform.service.WeatherService;
import com.weather.platform.utils.MongoHelper;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;
    private final WeatherDataMapper weatherDataMapper;
    private final MongoHelper mongoHelper;

    @Autowired
    public WeatherServiceImpl(final WeatherRepository weatherRepository,
                              final WeatherDataMapper weatherDataMapper,
                              final MongoHelper mongoHelper) {
        this.weatherRepository = weatherRepository;
        this.weatherDataMapper = weatherDataMapper;
        this.mongoHelper = mongoHelper;
    }

    @Override
    public List<WeatherDataDto> getWeatherData() {

        return this.weatherRepository.findAll()
                .stream()
                .map(this.weatherDataMapper::daoToDto)
                .toList();
    }

    @Override
    public List<WeatherDataDto> searchWeatherData(final String sensorId,
                                                  final String sensorLocation,
                                                  final ZonedDateTime minTime,
                                                  final ZonedDateTime maxTime) {
        final Instant minInstant = Optional.ofNullable(minTime)
                .map(ZonedDateTime::toInstant)
                .orElse(MIN_MONGO_TIME);
        final Instant maxInstant = Optional.ofNullable(maxTime)
                .map(ZonedDateTime::toInstant)
                .orElse(MAX_MONGO_TIME);

        final String sensorIdQuery = this.mongoHelper.prefixSearchForString(sensorId);
        final String sensorLocationQuery = this.mongoHelper.prefixSearchForString(sensorLocation);

        return this.weatherRepository.findByIdLocationTime(sensorIdQuery,
                sensorLocationQuery,
                minInstant,
                maxInstant)
                .stream()
                .map(this.weatherDataMapper::daoToDto)
                .toList();
    }

    @Override
    public WeatherDataDto saveWeatherData(final WeatherDataDto toSave) {
        final WeatherDataDao saved = this.weatherRepository.save(this.weatherDataMapper.dtoToDao(toSave));
        return this.weatherDataMapper.daoToDto(saved);
    }
}
