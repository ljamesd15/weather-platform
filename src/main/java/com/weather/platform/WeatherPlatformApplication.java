package com.weather.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(mongoTemplateRef = "Weather")
public class WeatherPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherPlatformApplication.class, args);
    }
}
