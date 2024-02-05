package com.weather.platform.service.impl;

import com.weather.platform.mapper.WeatherDataMapper;
import com.weather.platform.model.dao.WeatherDataDao;
import com.weather.platform.model.dto.WeatherDataDto;
import com.weather.platform.repository.WeatherRepository;
import com.weather.platform.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;
    private final WeatherDataMapper weatherDataMapper;

    @Autowired
    public WeatherServiceImpl(final WeatherRepository weatherRepository, final WeatherDataMapper weatherDataMapper) {
        this.weatherRepository = weatherRepository;
        this.weatherDataMapper = weatherDataMapper;
    }

    @Override
    public List<WeatherDataDto> getWeatherData() {
        return this.weatherRepository.findAll()
                .stream()
                .map(this.weatherDataMapper::daoToDto)
                .toList();
    }

    @Override
    public WeatherDataDto saveWeatherData(final WeatherDataDto toSave) {
        final WeatherDataDao saved = this.weatherRepository.save(this.weatherDataMapper.dtoToDao(toSave));
        log.info("Saved temp: {}", saved.getTemperature());
        return this.weatherDataMapper.daoToDto(saved);
    }
}
