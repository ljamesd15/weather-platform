package com.weather.platform.config;

import static org.mockito.Mockito.mock;

import com.weather.platform.repository.WeatherRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MockRepositories {

    @Bean
    public WeatherRepository weatherRepository() {
        return mock(WeatherRepository.class);
    }
}
